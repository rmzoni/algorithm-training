package ai.backtracking

/**
 * How can N queens be placed on an NxN chessboard so that no two of them attack each other?
 * No two queens are on the same row, column, or diagonal.
 * @author Rafael Manzoni
 */
class NQueens {
  
  def resolve(n: Int): Array[Array[Int]] = {
    def place(k: Int): Array[Array[Int]] =
      if (k == 0) Array(Array())
      else
        for {
          queens <- place(k - 1)
          col <- 1 to n
          if isSafe(col, queens)
        } yield queens :+ col
  
    def isSafe(col: Int, queens: Array[Int]): Boolean = {
      val row = queens.length
      val queensWithRow = (0 until row) zip queens
      queensWithRow forall {
        case (r, c) => col != c && math.abs(col - c) != row - r
      }
    }
    place(n)
  }  
  
}