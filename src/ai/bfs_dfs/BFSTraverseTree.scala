package ai.bfs_dfs
import scala.collection.immutable.Queue

class BFSTraverseTree {

  class Tree[T](x: T) {
    var value: T = x
    var left: Option[Tree[T]] = None
    var right: Option[Tree[T]] = None
  }

  def traverse(t: Option[Tree[Int]]): Array[Int] = {

    var q = Queue.empty[Tree[Int]]
    var ls = List.empty[Int]

    t match {
      case Some(x) => {
        q = q :+ x
        while (!q.isEmpty) {
          val current = q.head
          q = q.tail
          ls = ls ::: List(current.value)

          current.left match {
            case Some(l) => q = q :+ l
            case _       =>
          }

          current.right match {
            case Some(r) => q = q :+ r
            case _       =>
          }
        }
      }
      case _ =>
    }

    ls.toArray
  }

}