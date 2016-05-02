package com.example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object Hello extends App {
  implicit val system = ActorSystem("sbt-intro")
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher

  val route =
    path("hello") {
      get {
        complete {
          "ha ha ha  asdasd"
        }
      }
    }

  val bindingFuture = Http()
    .bindAndHandle(route, "0.0.0.0", 9000)
    .foreach(_ => println(s"listening on port 9000"))
}
