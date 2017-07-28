package ai.bfs_dfs

class DFSDigitTreeSum {

  class Tree[T](x: T) {
    var value: T = x
    var left: Option[Tree[T]] = None
    var right: Option[Tree[T]] = None
  }

  def calculate(t: Option[Tree[Int]]): Long = {

    def calculatesPaths(t: Option[Tree[Int]], acc: List[Int]): List[List[Int]] = {
      t match {
        case Some(x) if x.left.isEmpty && x.right.isEmpty => List(x.value :: acc)
        case Some(x)                                      => calculatesPaths(x.left, x.value :: acc) ::: calculatesPaths(x.right, x.value :: acc)
        case None                                         => List(Nil)
      }

    }

    calculatesPaths(t, List()).filter(a => a.size != 0).map(a => a.reverse.mkString.toLong).sum

  }

}