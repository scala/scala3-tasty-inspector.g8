package inspector

import scala.tasty.inspector._

import org.junit.Test
import org.junit.Assert._

class InspectorTest {

  @Test def test(): Unit = {
    assertEquals(
      """package lib {
        |  @scala.annotation.internal.SourceFile("lib/src/main/scala/lib/Greetings.scala") object Greetings {
        |    def hello(name: scala.Predef.String): scala.Predef.String = "Hello ".+(name)
        |  }
        |}""".stripMargin,
      Inspector.showCodeOf("lib/target/scala-3.6.3/classes/lib/Greetings.tasty")
    )

  }
}
