package io.freevariable.taskcake

import slick.jdbc.JdbcBackend.Database

import scala.concurrent.ExecutionContext

class PostgresDataAccessLayer(database: Database)(implicit ec: ExecutionContext) extends DatabaseLayer with DataAccessLayer {
  val profile = slick.jdbc.PostgresProfile
  val db = database
}
