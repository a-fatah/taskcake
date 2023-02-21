import Dependencies._

ThisBuild / scalaVersion     := "2.13.10"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "io.freevariable"
ThisBuild / organizationName := "freevariable"

lazy val root = (project in file("."))
  .settings(
    name := "taskcake",
    libraryDependencies += munit % Test
  )

libraryDependencies ++= Seq(
  slick,
  hikaricp,
  postgresql,
  h2 % Test,
  munit % Test,
  munitScalacheck % Test
)
