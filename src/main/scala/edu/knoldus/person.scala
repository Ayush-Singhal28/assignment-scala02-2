package edu.knoldus

import org.apache.log4j.Logger

abstract class Person()

case class Gamer() extends Person

case class Trainer() extends Person

case class Blogger() extends Person

class PersonTask {

  def findTaskPerformed(className: Person): String = {
    val rollingNumber = new scala.util.Random
    className match {
      case a: Gamer => rollingDice(0)
      case b: Trainer => classStrength()
      case c: Blogger => {
        val blogList = Map("Scala" -> 2, "Java" -> 5, "Kafka" -> 6)
        maxNumOfBlogs(blogList, 0)
      }
    }
  }

  def rollingDice(chances: Int): String = {
    val rollingNumber = new scala.util.Random
    val r = rollingNumber.nextInt(Constant.SEVEN) + 1
    r match {
      case Constant.ONE | Constant.SIX if (chances < Constant.THREE) => rollingDice(chances + Constant.ONE)
      case _ => "looser"
    }
  }


  def classStrength(): String = {
    val rollingNumber = scala.util.Random
    s"class strength is ${rollingNumber.nextInt(Constant.FIFTYONE)}"
  }

  val random = scala.util.Random

  def maxNumOfBlogs(blogList: Map[String, Int], noOfBlogs: Int): String = {
    val technology = blogList.keySet
    val blogNumber = technology.toVector(random.nextInt(technology.size))
    if (noOfBlogs < 5) {
      maxNumOfBlogs(blogList updated(blogNumber, blogList(blogNumber) + 1), noOfBlogs + 1)
    }
    else {
      blogList.keysIterator.max
    }
  }

}

