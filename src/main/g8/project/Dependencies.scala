import sbt._

object Dependencies {
  object versions {
    lazy val kindProjectorVersion = "0.13.0"
    lazy val scalatestVersion = "3.2.8"
  }

  lazy val scalaTest = "org.scalatest" %% "scalatest" % versions.scalatestVersion
}