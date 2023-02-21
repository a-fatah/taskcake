package io.freevariable.taskcake

import slick.jdbc.JdbcBackend.Database

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {
  val database = Database.forConfig("postgres")

  val dataAccess = new PostgresDataAccessLayer(database)

  database.run(dataAccess.getUsers()).foreach(println)
}
