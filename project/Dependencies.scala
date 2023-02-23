import sbt._

object Dependencies {
  lazy val munit = "org.scalameta" %% "munit" % "0.7.29"
  lazy val munitScalacheck = "org.scalameta" %% "munit-scalacheck" % "0.7.29"
  lazy val slick = "com.typesafe.slick" %% "slick" % "3.3.3"
  lazy val slickHikaricp = "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3"
  lazy val postgresql = "org.postgresql" % "postgresql" % "42.2.23"
  lazy val h2 = "com.h2database" % "h2" % "1.4.200"
}
