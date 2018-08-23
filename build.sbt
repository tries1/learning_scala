name := "learning_scala"

version := "1.0"

lazy val `learning_scala` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(jdbc
  , ehcache
  , ws
  , specs2 % Test
  , guice
  , "com.typesafe.play" % "anorm_2.12" % "2.5.3"
  , "mysql" % "mysql-connector-java" % "5.1.34"
  , "com.typesafe.slick" %% "slick" % "3.2.3"
  , "com.typesafe.slick" %% "slick-hikaricp" % "3.2.3"
  , "org.scalaz" %% "scalaz-core" % "7.2.26"
  , "org.json4s" %% "json4s-native" % "3.6.0"
  , "com.github.tototoshi" %% "slick-joda-mapper" % "2.3.0"
  /*, "org.scalatestplus.play" % "scalatestplus-play_2.12" % "3.1.2" % Test*/)

unmanagedResourceDirectories in Test <+= baseDirectory(_ / "target/web/public/test")

      