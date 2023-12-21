import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    val input = StdIn.readLine()

    var bit = input.count(_ == '1') % 2
    if (input.last == 'o') bit = (bit + 1) % 2

    println(input.init + bit.toString)
  }
}