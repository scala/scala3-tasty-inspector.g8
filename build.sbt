// This build is for this Giter8 template.
// To test the template run `g8` or `g8Test` from the sbt session.
// See http://www.foundweekends.org/giter8/testing.html#Using+the+Giter8Plugin for more details.
import sbt.protocol.testing.TestResult

lazy val scalaVersions = Seq("3.10.0")
lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-tasty-inspector-template",
    scalaVersion := scalaVersions.head,
    Test / test := {
      val _ = (Test / g8Test).toTask("").value
      TestResult.Passed
    },
    scriptedLaunchOpts ++= List("-Xms1024m", "-Xmx1024m", "-XX:ReservedCodeCacheSize=128m", "-Xss2m", "-Dfile.encoding=UTF-8"),
    scriptedKeepTempDirectory := false,
    // sbt 2's target is target/out/jvm/<scala>/<project>. CI still enters target/sbt-test.
    sbtTestDirectory := baseDirectory.value / "target" / "sbt-test",
    crossScalaVersions := scalaVersions
  )

ThisBuild / githubWorkflowJavaVersions := Seq("17", "21", "25").map(JavaSpec.temurin)
ThisBuild / githubWorkflowScalaVersions := scalaVersions
ThisBuild / githubWorkflowBuildPostamble := Seq(
  // This runs the template with the default parameters, and runs test within the templated app.
  WorkflowStep.Run(List("sbt -Dfile.encoding=UTF8 -J-XX:ReservedCodeCacheSize=256M test")),
  WorkflowStep.Run(List("pushd target/sbt-test/scala3-tasty-inspector-template/scripted && sbt \"inspector/run; test\" && popd")),
)
ThisBuild / githubWorkflowPublishTargetBranches := Nil
Global / onChangedBuildSource := ReloadOnSourceChanges
