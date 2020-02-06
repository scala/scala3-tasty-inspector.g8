
import scala.tasty.inspector._

import org.junit.Test
import org.junit.Assert._

class InspectorTest {

  @Test def test(): Unit = {
    assertEquals(
      """package lib {
        |  @scala.annotation.internal.SourceFile("lib/src/main/scala/lib/Greetings.scala") object Greetings {
        |    def hello(name: scala.Predef.String): scala.Predef.String = _root_.scala.StringContext.apply("Hello ", "").s(name)
        |  }
        |}""".stripMargin, 
      Inspector.showCodeOf("lib.Greetings")
    )

  }
}
