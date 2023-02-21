package io.freevariable.taskcake

import scala.concurrent.Future

trait DatabaseLayer {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._

  val db: Database

  def run[R](action: DBIO[R]): Future[R] = db.run(action)
}
