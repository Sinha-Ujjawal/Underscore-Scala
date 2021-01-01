package sections.section4

import scala.annotation.tailrec

object Exercise631 extends App {
  //   A List of Methods
  // Using our definition of IntList
  // sealed trait IntList
  // case object End extends IntList
  // final case class Pair(head: Int, tail: IntList) extends IntList
  // define a method length that returns the length of the list. There is test data
  // below you can use to check your solution. For this exercise it is best to use
  // pattern matching in the base trait.
  // val example = Pair(1, Pair(2, Pair(3, End)))
  // assert(example.length == 3)
  // assert(example.tail.length == 2)
  // assert(End.length == 0)
  // Define a method to compute the product of the elements in an IntList. Test
  // cases are below.
  // assert(example.product == 6)
  // assert(example.tail.product == 6)
  // assert(End.product == 1)
  // Define a method to double the value of each element in an IntList, returning
  // a new IntList. The following test cases should hold:
  // assert(example.double == Pair(2, Pair(4, Pair(6, End))))
  // assert(example.tail.double == Pair(4, Pair(6, End)))
  // assert(End.double == End)

  sealed trait IntList {
    def length: Int = {
      @tailrec
      def lengthUtil(list: IntList, acc: Int = 0): Int =
        list match {
          case End           => acc
          case Pair(_, tail) => lengthUtil(tail, acc + 1)
        }
      lengthUtil(this)
    }

    def product: Int = {
      @tailrec
      def productUtil(list: IntList, acc: Int = 1): Int =
        list match {
          case End              => acc
          case Pair(head, tail) => productUtil(tail, acc * head)
        }
      productUtil(this)
    }

    def reverse: IntList = {
      @tailrec
      def reverseUtil(list: IntList, acc: IntList = End): IntList =
        list match {
          case End              => acc
          case Pair(head, tail) => reverseUtil(tail, Pair(head, acc))
        }
      reverseUtil(this)
    }

    def double: IntList = {
      @tailrec
      def doubleUtil(list: IntList, acc: IntList = End): IntList =
        list match {
          case End              => acc
          case Pair(head, tail) => doubleUtil(tail, Pair(head << 1, acc))
        }
      doubleUtil(this).reverse
    }
  }
  case object End extends IntList
  final case class Pair(head: Int, tail: IntList) extends IntList

  val example = Pair(1, Pair(2, Pair(3, End)))

  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(End.length == 0)

  assert(example.product == 6)
  assert(example.tail.product == 6)
  assert(End.product == 1)

  assert(example.double == Pair(2, Pair(4, Pair(6, End))))
  assert(example.tail.double == Pair(4, Pair(6, End)))
  assert(End.double == End)
}
