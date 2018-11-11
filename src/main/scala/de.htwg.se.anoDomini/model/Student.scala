package de.htwg.se.anoDomini

object Hello{ //companion Object
  def main(args: Array[String]): Unit ={ //this makes this an Applitcation
    val student = Student("Your Name")
    println("Hello, " + student.name)
  }
}

package de.htwg.se.anoDomini.model

case class Student(name: String) {
  def f(x: Int) : Int = x + 1
}
