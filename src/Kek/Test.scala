import scala.io.StdIn.{readLine}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source

object Test {
  def main(args: Array[String]) {
    def guesserFunc(secrNum: Int) {
      val secretNumber = secrNum
      var numberGuessed = 0


      do {
        print("Guess the numbreh: ")
        numberGuessed = readLine.toInt

      } while (numberGuessed != secretNumber)
      printf("You guessed the secret numbreh %d\n", secretNumber)
    }

    def funcWithReturn(num1: Float, num2: Int): String = {
      num1 + num2 + "kek"
    }

    def factorial(num: BigInt): BigInt = {
      if (num <= 1) 1
      else num * factorial(num - 1)
    }

    def functionale(): Unit = {
      var nums = for (i <- 0 to 8) yield i
      for (v <- nums) print(v + " ")

      var nums2 = for (i <- nums if (i % 2) == 0 && i > 0) yield i
      for (v <- nums2) print(v + " ")
    }

    def dobleArr(): Unit = {
      val len1 = 10
      val len2 = 10
      var doble = Array.ofDim[BigInt](len1, len2)
      for (i <- 0 to len1 - 1)
        for (j <- 0 to len2 - 1) {
          doble(i)(j) = i * j
          printf("[%d][%d] = %d\n", i, j, doble(i)(j))
        }
    }

    def maps(): Unit = {
      val cats = collection.mutable.Map("Siam" -> "Katty", "Doge" -> "Refrain")
      cats("Yolo") = "Perry"
      cats("Yolo") = "Supreme"
      for ((v, n) <- cats) {
        println(v + " : " + n)
      }
    }

    def formatMadness(): Unit = {
      val holder = "%d is belong to %s".format(12, "Teddy")
      println(holder)
    }
    formatMadness()

  }


}