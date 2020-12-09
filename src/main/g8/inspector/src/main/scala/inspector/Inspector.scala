
package inspector

import scala.quoted._

import scala.tasty.inspector.TastyInspector

object Inspector {

  def showCodeOf(tastyFile: String): String = {
    var tastyStr: String = null
    val inspector = new TastyInspector {
      protected def processCompilationUnit(using Quotes)(root: quotes.reflect.Tree): Unit = {
        import quotes.reflect._
        val projectDir = new java.io.File( "." ).getCanonicalPath() + java.io.File.separator // To cleanup the paths in @SourceFile
        tastyStr = root.show.replace(projectDir, "")
      }
    }
    inspector.inspectTastyFiles(List(tastyFile))
    tastyStr
  }
  
}
