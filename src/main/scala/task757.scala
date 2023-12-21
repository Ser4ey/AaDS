//import scala.io.StdIn
//
//
//case class Node(value: Int, level: Int, var left: Option[Node] = None, var right: Option[Node] = None) {
//  def add_node(node_value: Int): Unit =
//    if (node_value < this.value) left match
//      case None => this.left = Some(Node(node_value, this.level + 1))
//      case Some(left_node) => left_node.add_node(node_value)
//    else if (node_value > this.value) right match
//      case None => this.right = Some(Node(node_value, this.level + 1))
//      case Some(right_node) => right_node.add_node(node_value)
//
//  def print_tree(): Unit =
//    if (this.level == 1)
//      println(s"${this.value}")
//    else
//      println(s"${"-" * 4 * (this.level - 1)} ${this.value}")
//    this.left.map(_.print_tree())
//    this.right.map(_.print_tree())
//
//  def find_max_level(): Int =
//    Math.max(
//      this.level,
//      Math.max(
//        this.left.map(_.find_max_level()).getOrElse(1),
//        this.right.map(_.find_max_level()).getOrElse(1)
//      )
//    )
//
//}
//
//
//object Task757 extends App {
//  //   val input = "7 3 2 1 9 5 4 6 8 0"
//  val input = StdIn.readLine()
//  val a: Array[Int] = input.split(" ").map(_.toInt)
//
//  val first_node = Node(value = a.head, level = 1)
//  for (n <- a.tail.init) first_node.add_node(n)
//
//  first_node.print_tree()
//  println("_" * 20)
//  println(first_node.find_max_level())
//
//}