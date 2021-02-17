val scala3Version = "3.0.0-RC1"

lazy val lib = project
  .in(file("lib"))
  .settings(
    name := "lib",
    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )

lazy val inspector = project
  .in(file("inspector"))
  .settings(
    name := "inspector",
    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scala-lang" %% "scala3-tasty-inspector" % scala3Version,
      "com.novocode" % "junit-interface" % "0.11" % "test"
    )
  )
  .dependsOn(lib)
