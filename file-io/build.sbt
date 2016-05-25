organization  := "bmeg"

name := "gaea-graph"

version := "1.0"

scalaVersion := "2.11.8"

conflictManager := ConflictManager.strict.copy(organization = "com.esotericsoftware.*")

libraryDependencies ++= Seq(
  "com.thinkaurelius.titan" % "titan-core"       % "1.1.0-SNAPSHOT",
  "org.apache.tinkerpop"    % "gremlin-core"     % "3.1.1-incubating",
  "com.google.protobuf"     % "protobuf-java"    % "3.0.0-beta-2"
)

//resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

resolvers ++= Seq(
  "Akka Repository" at "http://repo.akka.io/releases/",
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases",
  "Twitter Maven Repo" at "http://maven.twttr.com",
  "GAEA Depends Repo" at "https://github.com/bmeg/gaea-depends/raw/master/"
)
