import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "FuseSocial"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add bootstrapp to the path for less compiling! ^^
      lessEntryPoints <<= baseDirectory(customLessEntryPoints)
    )

    // Compile Bootstrap
    def customLessEntryPoints(base: File): PathFinder = (
    (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap.less") +++
      (base / "app" / "assets" / "stylesheets" * "*.less")
    )

}
