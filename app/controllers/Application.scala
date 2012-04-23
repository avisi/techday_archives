package controllers

import auth.providers.Facebook
import play.api.mvc.{Action, Controller}
import helpers.Url
import play.api.libs.ws.WS
import play.api.Play
import play.api.Play.current

object Application extends Controller{

  val graph_url = Play.configuration.getString("facebook.url.graph").get

  def index = Action {
      Ok(views.html.index("Welkom op de index pagina"))
  }

  def authenticated = Facebook.Authenticated { token => implicit request =>
    Async {
      val params = Url.queryString(Map(
        "access_token" -> token
      ))
      WS.url(graph_url+ "/me" + params).get().map {
        response =>
          val result = response.json.\("name")
          Ok(views.html.authenticated(result.as[String]))
      }
    }
  }
}
