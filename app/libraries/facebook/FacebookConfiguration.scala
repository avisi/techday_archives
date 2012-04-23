package libraries.facebook

import play.api.Play
import play.api.Play.current

class FacebookConfiguration (
  val url: String = "https://www.facebook.com",
  val graphUrl: String = "https://graph.facebook.com"
                              ) {
  val appId: String = Play.configuration.getString("facebook.app_id").get
  val secret: String = Play.configuration.getString("facebook.secret").get
}

object FacebookConfiguration {
  val configuration = new FacebookConfiguration

  def facebookConfiguration:FacebookConfiguration = configuration

}
