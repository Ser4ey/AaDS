import scala.io.StdIn

object some extends App {
  val input = StdIn.readLine()

  val Array(a, b) = input.split(" ").map(_.toInt)

  var number = a
  var ans = 0

  for (i <- 0 to b) {
    ans = number % 2
    number = number / 2
  }
  println(ans)
}