package inspector

import scala.tasty.inspector._

import org.junit.Test
import org.junit.Assert._

class InspectorTest {

  @Test def test(): Unit = {
    assertEquals(
      """package lib {
        |  object Greetings {
        |    def hello(name: scala.Predef.String): scala.Predef.String = "Hello ".+(name)
        |  }
        |}""".stripMargin,
      Inspector.showCodeOf("lib/target/scala-3.10.0/classes/lib/Greetings.tasty")
    )

  }
}
