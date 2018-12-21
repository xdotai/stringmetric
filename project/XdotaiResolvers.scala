import sbt._
import Keys._
import sbt.IO

object XdotaiResolvers {

  val s3JarRepoUrl = IO.read( file(".") / "project/project/artifactory.url" ).trim

  val localSnapshots = "snapshots" at s"$s3JarRepoUrl/libs-snapshot-local"
  val localReleases = "releases" at s"$s3JarRepoUrl/libs-release-local"
  val allResolvers =  Seq(
    localSnapshots,
    localReleases,
    Resolver.sonatypeRepo("releases"),
    Resolver.typesafeRepo("releases"),
    "Spray Releases" at "http://repo.spray.io",
    Resolver.sonatypeRepo("snapshots")
  )
}
