import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "avisi-techday"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(

    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add bootstrapp to the path for less compiling! ^^
              lessEntryPoints <<= baseDirectory(customLessEntryPoints)
    )

    // Compile Bootstrap
    def customLessEntryPoints(base: File): PathFinder = (
        (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap.less") +++
        (base / "app" / "assets" / "stylesheets" * "*.less")
    )

}
