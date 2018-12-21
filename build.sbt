val currentVersion = "0.28.1-forked"
val scala211 = "2.11.12"
val scala212 = "2.12.8"


lazy val root = Project(
        id = "stringmetric",
        base = file(".") 
        )
        .settings(
          version := currentVersion,
          organization := "ai.x",
          publishTo := Some( XdotaiResolvers.localReleases ),
          scalaVersion := scala212,
          crossScalaVersions := Seq( scala211, scala212 )
        )
        .aggregate(core, cli) 

lazy val core = 
  Project(
    id = "core",
    base = file("core"),
  )
  .settings(
      version := currentVersion,
      organization := "ai.x",
      publishTo := Some( XdotaiResolvers.localReleases ),
			libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.8.6" % "test"),
			name := "stringmetric-core",
      scalaVersion := scala212,
      crossScalaVersions := Seq( scala211, scala212 )
	)

lazy val cli: Project = 
  Project(
    id = "cli",
    base = file("cli"),
  )
  .settings(
      version := currentVersion,
      organization := "ai.x",
      publishTo := Some( XdotaiResolvers.localReleases ),
			libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.8.6" % "test"),
			name := "stringmetric-cli",
      scalaVersion := scala212,
      crossScalaVersions := Seq( scala211, scala212 )
  )
	.dependsOn(core)


