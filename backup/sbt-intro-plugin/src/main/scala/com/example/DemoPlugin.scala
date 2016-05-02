package com.example

import sbt.Keys._
import sbt._

object DemoPlugin extends AutoPlugin {

  object autoImport {
    val copyPkg = taskKey[File]("copy jar")
  }

  import autoImport._

  lazy val copyPgkTask = Def.task {
    val dd = baseDirectory.value / "target" / "aaa"
    IO.copyFile((packageBin in Compile).value, dd, true)
    dd
  }

  override def projectSettings = Seq(
    copyPkg := copyPgkTask.value
  )

}
