package com.example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.io.StdIn

object Hello extends App {
  implicit val system = ActorSystem("sbt-intro")
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher

  val route =
    path("hello") {
      get {
        complete {
          "Say hello to akka-http"
        }
      }
    }

  val bindingFuture = Http()
    .bindAndHandle(route, "0.0.0.0", 9000)
    .foreach(_ => println(s"listening on port 9000"))

//  println(s"Server online at http://localhost:9000/\nPress RETURN to stop...")
//  StdIn.readLine() // for the future transformations
//  bindingFuture
//    .flatMap(_.unbind()) // trigger unbinding from the port
//    .onComplete(_ ⇒ system.terminate()) // and shutdown when done
}
