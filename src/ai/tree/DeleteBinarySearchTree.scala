package ai.tree

class DeleteBinarySearchTree {

  class Tree[T](x: T) {
    var value: T = x
    var left: Option[Tree[T]] = None
    var right: Option[Tree[T]] = None
  }

  def minValue(t: Option[Tree[Int]]): Int = {
    t match {
      case Some(x) if x.right.isEmpty => x.value
      case Some(x)                    => minValue(x.right)
      case None                       => 0
    }
  }

  def delete(t: Option[Tree[Int]], k: Int): Option[Tree[Int]] = {

    t match {
      case Some(x) if x.value == k => {
        if (!x.left.isEmpty) {
          val min = minValue(x.left);
          x.value = min
          x.left = delete(x.left, min);
          Some(x)
        } else {
          x.right
        }
      }
      case Some(x) if k < x.value => {
        x.left = delete(x.left, k)
        Some(x)
      }
      case Some(x) if k > x.value => {
        x.right = delete(x.right, k)
        Some(x)
      }
      case None => None
    }

  }

}