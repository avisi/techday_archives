package controllers.auth.providers

import java.util.UUID
import play.api.libs.Crypto
import play.api.libs.ws.WS
import scala.Array
import play.api.Play
import play.api.Play.current
import helpers.Url
import play.api.mvc._

object Facebook extends Controller {
  val security_token_key = "atoken"

  // keys
  val application_id = Play.configuration.getString("facebook.app_id").get
  val application_secret = Play.configuration.getString("facebook.secret").get

  // urls
  val access_token_url = Play.configuration.getString("facebook.url.access_token").get
  val authorization_url = Play.configuration.getString("facebook.url.authorize").get

  def authorize = Action {
    implicit request =>
      val token = UUID.randomUUID().toString
      val params = Url.queryString(Map(
        "client_id" -> application_id,
        "redirect_uri" -> routes.Facebook.getAccessToken().absoluteURL(),
        "state" -> token
      ))
      Redirect(authorization_url + params).withNewSession
        .withSession(security_token_key -> Crypto.sign(token))
  }

  def getAccessToken = Secured { implicit request =>
     request.queryString.get("code").map { code =>
        Async {
          val params = Url.queryString(Map(
            "client_id" -> application_id,
            "redirect_uri" -> routes.Facebook.getAccessToken().absoluteURL(),
            "client_secret" -> application_secret,
            "code" -> code(0)
          ))

          WS.url(access_token_url + params).get().map {
            response =>
              val result = response.body.toString.split(Array[Char]('=', '&'))
              val (token, expires) = (result(1), result(3))
              Redirect(controllers.routes.Application.authenticated()).withNewSession.withSession(("token" -> token), ("expires" -> expires))
          }
        }
      }.getOrElse {
        Unauthorized("You need to accept the facebook permissions to be able to login")
      }
  }

  def Authenticated(f: String => Request[AnyContent] => Result) = {
    Action { request =>
      request.session.get("token").map{token => f(token)(request)}
        .getOrElse(Unauthorized)
    }
  }

  def Secured(action: Request[AnyContent] => Result): Action[AnyContent] = {
    Action { request =>
      val remoteToken = Crypto.sign(request.queryString.get("state").get(0))
      val localToken = request.session.get(security_token_key).getOrElse[String]("")
      if(localToken equals remoteToken) {
        action(request)
      } else {
        Unauthorized("Not a valid session, you could be a victim of an CSRF attack.")
      }
    }
  }

}
