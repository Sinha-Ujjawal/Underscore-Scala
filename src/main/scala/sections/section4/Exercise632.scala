package sections.section4

object Exercise632 extends App {
  // The Forest of Trees
  // A binary tree of integers can be defined as follows:
  // A Tree is a Node with a left and right Tree or a Leaf with an element of type
  // Int.
  // Implement this algebraic data type.
  // Implement sum and double on Tree using polymorphism and pattern matching.

  sealed trait Tree
  final case class Node(left: Tree, right: Tree) extends Tree
  final case class Leaf(el: Int) extends Tree

  object TreeOps {
    def sum(tree: Tree): Int =
      tree match {
        case Node(left, right) => sum(left) + sum(right)
        case Leaf(el)          => el
      }

    def double(tree: Tree): Tree =
      tree match {
        case Node(left, right) => Node(double(left), double(right))
        case Leaf(el)          => Leaf(el << 1)
      }
  }
}
