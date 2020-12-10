val dottyVersion = "3.0.0-M2"

lazy val lib = project
  .in(file("lib"))
  .settings(
    name := "lib",
    version := "0.1.0",

    scalaVersion := dottyVersion,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )

lazy val inspector = project
  .in(file("inspector"))
  .settings(
    name := "inspector",
    version := "0.1.0",

    scalaVersion := dottyVersion,

    libraryDependencies ++= Seq(
      "org.scala-lang" %% "scala3-tasty-inspector" % dottyVersion,
      "com.novocode" % "junit-interface" % "0.11" % "test"
    )
  )
  .dependsOn(lib)
