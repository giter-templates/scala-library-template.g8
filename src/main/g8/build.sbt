val scala2_13 = "2.13.8"

val compileAndTest = "compile->compile;test->test"

lazy val compilerOptions: Seq[String] = Seq(
  "-deprecation",
  "-unchecked",
  "-encoding",
  "UTF-8",
  "-explaintypes",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:existentials",
  "-language:postfixOps",
  "-Ywarn-dead-code",
  "-Xlint",
  "-Xlint:constant",
  "-Xlint:inaccessible",
  "-Xlint:nullary-unit",
  "-Xlint:type-parameter-shadow",
  "-Xlint:_,-byname-implicit",
  "-Ymacro-annotations",
  "-Wdead-code",
  "-Wnumeric-widen",
  "-Wunused:explicits",
  "-Wunused:implicits",
  "-Wunused:imports",
  "-Wunused:locals",
  "-Wunused:patvars",
  "-Wunused:privates",
  "-Wvalue-discard",
  "-Xlint:deprecation",
  "-Xlint:eta-sam",
  "-Xlint:eta-zero",
  "-Xlint:implicit-not-found",
  "-Xlint:infer-any",
  "-Xlint:nonlocal-return",
  "-Xlint:unused",
  "-Xlint:valpattern"
)

lazy val buildSettings = Seq(
  scalaVersion := scala2_13,
  scalacOptions ++= compilerOptions,
  Test / parallelExecution := false
)

lazy val noPublish = Seq(
  publish := {},
  publishLocal := {},
  publishArtifact := false
)

lazy val commonSettings = Seq(
  libraryDependencies ++= Seq(
    zioConfig,
    zioConfigMagnolia,
    zioConfigTypesafe,
    scalaTest % Test
  ),
  addCompilerPlugin(
    ("org.typelevel" %% "kind-projector" % versions.kindProjectorVersion).cross(CrossVersion.full)
  )
)

lazy val $name$ =
  project
    .in(file("."))
    .settings(buildSettings)
    .settings(noPublish)
    .settings(moduleName := "$name$")
    .aggregate(core)

lazy val core =
  project
    .in(file("modules/core"))
    .settings(buildSettings)
    .settings(commonSettings)
    .settings(moduleName := "$name$-core")