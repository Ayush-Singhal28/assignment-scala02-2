sealed abstract class Person

case class Gamer() extends Person

case class Trainer() extends Person

case class Blogger() extends Person

def findTaskPerformed(className: Person): String = {
  val rollingNumber = new scala.util.Random
  className match {
    case Gamer => rollingDice(0, (rollingNumber.nextInt(7) + 1))
    case Trainer => classStrength(rollingNumber.nextInt(51))
    case Blogger => maxNumOfBlogs(blogList, noOfBlogs)
  }

  def rollingDice(chances: Int, rollingNumber: Int): String = {
    val rollingNumber = new scala.util.Random
    chances match {
      case 3 => "winner"
      case chances => if(rollingNumber == 1 || rollingNumber == 6) {
                          rollingDice(chances + 1, rollingNumber.nextInt(7) + 1)
      }
      else {

      }
    }
  }


  def classStrength(): String = {
    val rollingNumber = new scala.util.Random
    s"class strength is ${rollingNumber.nextInt(51)}"
  }


   val random = scala.util.Random
    def innerBlogs(blogList: Map[String,Int], count: Int): (String,Int) = {
      val technology = blogList.keySet
      val blogNumber =technology.toVector(random.nextInt(technology.size))
      if(count < 5)
        {
          innerBlogs(blogList updated(blogNumber,blogList(blogNumber) + 1), count + 1)
        }
      else
        blogList.max
  }

}
