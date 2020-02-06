
import scala.tasty.Reflection
import scala.tasty.inspector.TastyInspector

object Inspector {

  @main def main = 
    println(Inspector.showCodeOf("lib.Greetings"))

  def showCodeOf(className: String): String = {
    var tastyStr: String = null
    val inspector = new TastyInspector {
      protected def processCompilationUnit(reflect: Reflection)(root: reflect.Tree): Unit = {
        import reflect.{given, _}
        val projectDir = new java.io.File( "." ).getCanonicalPath() + java.io.File.separator // To cleanup the paths in @SourceFile
        tastyStr = root.show.replace(projectDir, "")
      }
    }
    val classpath  = "" // Only use classpath of the dependencies of this project
    inspector.inspect(classpath, List(className))
    tastyStr
  }
  
}
