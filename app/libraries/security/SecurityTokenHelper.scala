package libraries.security

import play.api.mvc._
import play.api.mvc.Results._
import play.api.mvc.{Result, AnyContent, Request}

/**
 * Created with IntelliJ IDEA.
 * User: Mitchel Kuijpers
 * Date: 2-4-12
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */

object SecurityTokenHelper{

  val SECURITY_TOKEN_SESSION_KEY = "atoken"

  def generateSecurityToken(action: Request[AnyContent] => Result): Action[AnyContent] = {
    Action { request =>
      action(request)
    }
  }

  def isValidToken(action: Request[AnyContent] => Result): Action[AnyContent] = {
    Action { request =>
      request.session.get(SECURITY_TOKEN_SESSION_KEY).map{ token =>
        action(request)
      }.getOrElse(Unauthorized)
    }
  }

}
