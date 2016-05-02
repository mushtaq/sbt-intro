name := "sbt-intro"

scalaVersion in ThisBuild := "2.11.8"

val commonSettings = Seq(
  dockerExposedPorts := Seq(9000),
  organization := "com.example",
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-http-experimental" % "2.4.4",
    "org.scalatest" %% "scalatest" % "2.2.5" % "test"
  )
)

val common = project.settings(commonSettings)

val hello1 = project
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(DemoPlugin)
  .dependsOn(common)
  .settings(commonSettings)
  .settings(
    version := "1.0"
  )

val hello2 = project
  .enablePlugins(JavaAppPackaging)
  .dependsOn(common)
  .settings(commonSettings)
  .settings(
    version := "2.0"
  )
