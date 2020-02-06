package lib

import org.junit.Test
import org.junit.Assert._

class GreetingsTest {

  @Test def testHello(): Unit = {
    assertEquals("Hello world", Greetings.hello("world"))
    assertEquals("Hello Nicolas", Greetings.hello("Nicolas"))
  }
}
