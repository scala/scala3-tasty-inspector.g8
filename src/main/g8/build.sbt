val scala3Version = "3.7.4"

lazy val lib = project
  .in(file("lib"))
  .settings(
    name := "lib",
    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % "test"
  )

lazy val inspector = project
  .in(file("inspector"))
  .settings(
    name := "inspector",
    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scala-lang" %% "scala3-tasty-inspector" % scala3Version,
      "com.github.sbt" % "junit-interface" % "0.13.3" % "test"
    )
  )
  .dependsOn(lib)
