package inspector

import scala.quoted._

@main def run =
  val tastyFile = "target/out/jvm/scala-3.10.0/lib/classes/lib/Greetings.tasty"
  val tastyContents = Inspector.showCodeOf(tastyFile)
  println(tastyContents)
