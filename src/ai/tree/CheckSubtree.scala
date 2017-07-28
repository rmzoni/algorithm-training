package ai.tree

class CheckSubtree {

  class Tree[T](x: T) {
    var value: T = x
    var left: Option[Tree[T]] = None
    var right: Option[Tree[T]] = None
  }

  def equal(t1: Option[Tree[Int]], t2: Option[Tree[Int]]): Boolean = {

    (t1, t2) match {
      case (None, None)       => true
      case (Some(_), None)    => false
      case (None, Some(_))    => false
      case (Some(x), Some(y)) => x.value == y.value && equal(x.left, y.left) && equal(x.right, y.right)
    }

  }

  def check(t1: Option[Tree[Int]], t2: Option[Tree[Int]]): Boolean = {
    if (equal(t1, t2)) true
    else t1 match {
      case Some(x) => check(x.left, t2) || check(x.right, t2)
      case _       => false
    }
  }

}