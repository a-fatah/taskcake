package io.freevariable.taskcake

import scala.concurrent.ExecutionContext


trait DataAccessLayer {
  self: DatabaseLayer =>
  import profile.api._

  class Users(tag: Tag) extends Table[(Int, String, String)](tag, "users") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def email = column[String]("email")
    def * = (id, name, email)
  }

  class Task(tag: Tag) extends Table[(Int, String, String, Int)](tag, "tasks") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def description = column[String]("description")
    def userId = column[Int]("user_id")
    def * = (id, name, description, userId)
  }

  val users = TableQuery[Users]
  val tasks = TableQuery[Task]

  def getUserById(id: Int)(implicit ec: ExecutionContext): DBIO[Option[(Int, String, String)]] = {
    users.filter(_.id === id).result.headOption
  }

  def getTasksByUserId(id: Int)(implicit ec: ExecutionContext): DBIO[Seq[(Int, String, String, Int)]] = {
    tasks.filter(_.userId === id).result
  }

  def getUsers()(implicit ec: ExecutionContext): DBIO[Seq[(Int, String, String)]] = {
    users.result
  }

}
