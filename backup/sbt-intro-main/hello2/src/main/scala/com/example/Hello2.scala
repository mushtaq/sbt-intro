package com.example

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source

object Hello2 {
  implicit val system = ActorSystem("sbt-intro")
  implicit val mat = ActorMaterializer()
  import mat.executionContext

  def main(args: Array[String]): Unit = {
    Source('a' to 'z')
      .map(x => Lib.sayHello(x.toString))
      .runForeach(println)
      .onComplete(_ => system.terminate())
  }
}
