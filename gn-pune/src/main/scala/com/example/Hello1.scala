package com.example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object Hello1 extends App {
  implicit val system = ActorSystem("sbt-intro")
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher

  val route =
    path("hello1") {
      get {
        complete {
          "Say hello to akka-http"
        }
      }
    }

  val bindingFuture = Http()
    .bindAndHandle(route, "0.0.0.0", 9000)
    .foreach(_ => println(s"listening on port 9000, ha ha ha"))
}