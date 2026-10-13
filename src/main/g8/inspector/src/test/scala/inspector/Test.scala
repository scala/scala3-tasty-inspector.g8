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
      Inspector.showCodeOf("target/out/jvm/scala-3.10.0/lib/classes/lib/Greetings.tasty")
    )

  }
}
