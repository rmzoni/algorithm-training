package ai.tree

class SymmetricTree {

  class Tree[T](x: T) {
    var value: T = x
    var left: Option[Tree[T]] = None
    var right: Option[Tree[T]] = None
  }

  def isSymmetric(t: Option[Tree[Int]]): Boolean = {
    check(t, t)
  }

  def check(l: Option[Tree[Int]], r: Option[Tree[Int]]): Boolean = (l, r) match {
    case (None, None)       => true
    case (Some(_), None)    => false
    case (None, Some(_))    => false
    case (Some(a), Some(b)) => a.value == b.value && check(a.left, b.right) && check(a.right, b.left)
  }

}