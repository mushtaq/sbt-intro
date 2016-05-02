name := "gn-main"

organization := "com.example"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-experimental" % "2.4.4",
  "org.scalatest" %% "scalatest" % "2.2.5" % "test"
)

enablePlugins(JavaAppPackaging)


dockerExposedPorts := Seq(9000)

val copyArtifact = taskKey[File]("copies package jar in target")

copyArtifact := {
  val srcFile = (packageBin in Compile).value
  val destFile = baseDirectory.value / "target" / "copied.jar"
  IO.copyFile(srcFile, destFile, true)
  destFile
}

