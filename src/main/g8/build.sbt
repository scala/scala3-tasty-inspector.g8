val dottyVersion = "0.22.0-RC1"

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
      "ch.epfl.lamp" %% "dotty-tasty-inspector" % dottyVersion,
      "com.novocode" % "junit-interface" % "0.11" % "test"
    )
  )
  .dependsOn(lib)
