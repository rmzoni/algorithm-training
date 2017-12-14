import scala.util.Success
import scala.util.Try
import scala.collection.immutable.Stack
import scala.util.Failure

 class Tree[T](x : T) {
   var value: T = x
   var left: Option[Tree[T]] = None
   var right: Option[Tree[T]] = None
 }

 class ListNode[T](x : T) {
   var value: T = x
   var next: Option[ListNode[T]] = None
 }

object worksheet {
  	
  	type TypeMov = String
  	type Pos = (Int, Int)
  	type Mov = (Pos, TypeMov)
  	
  	val xMov = List(-2, -1, 1, 2, 1, -1);     
  	val yMov = List(0, -2, -2, 0, 2, 2);     
  	val nameMov = List("L", "UL", "UR", "R", "LR", "LL");
                                                  
  	
  	def findPaths(n: Int, current: List[Mov], end: Pos, visited: Set[Pos]):Array[List[Mov]] = {
  		
  		var solutions =  Array.empty[List[Mov]]
  		val lastPos = current.last._1
  		if(lastPos.equals(end)){
  			return Array(current);
  		}else{
  			// Calculate all possible movimentes
  			for(i <- 0 until xMov.size){
  				val newPos = (lastPos._1 + xMov(i), lastPos._2 + yMov(i))
  				if(newPos._1 >= 0 && newPos._1 < n && newPos._2 >= 0 && newPos._2 < n
  						&& !visited.contains(newPos)){
  						val newMov: Mov = (newPos, nameMov(i))
  						val possibleSolutions = findPaths(n, current ::: List(newMov), end, visited + newPos);
						for(sol <- possibleSolutions) solutions = solutions :+ sol
  				}
  			}
  		}
  		
  		return solutions;
  	}                                        
  	
  	def printShortestPath(n: Int, i_start: Int, j_start: Int, i_end: Int, j_end: Int):Unit  =  {
  		
        val solutions = findPaths(n, ((i_start, j_start), "") :: Nil, (i_end, i_end), Set.empty[Pos])
        if(solutions.isEmpty) System.out.println("Impossible")
        else {
        	val shortest = solutions.sortBy(f => f.size).head
        	System.out.println(shortest.size - 1)
        	System.out.println(shortest.tail.map(a => a._2).mkString(" "))
        }
    }                                          
  	
  	
  	def main(args: Array[String]) = printShortestPath(7, 6, 6, 0, 1)          //> Impossible
}
  	
  	