package helpers

object Url {

  def queryString(map: Map[String, String]): String = {
    var queryString = "?"
    for ((k, v) <- map) {
      queryString += k + "=" + v + "&"
    }
    queryString.substring(0, queryString.length - 1)
  }
}
