
package inspector

import scala.quoted._

import scala.tasty.inspector._

object Inspector {

  def showCodeOf(tastyFile: String): String = {
    var tastyStr: String = null
    val inspector = new Inspector {
      def inspect(using Quotes)(tastys: List[Tasty[quotes.type]]): Unit = {
        import quotes.reflect._
        for tasty <- tastys do
          val projectDir = new java.io.File( "." ).getCanonicalPath() + java.io.File.separator // To cleanup the paths in @SourceFile
          tastyStr = tasty.ast.show.replace(projectDir, "")
      }
    }
    TastyInspector.inspectTastyFiles(List(tastyFile))(inspector)
    tastyStr
  }

}
