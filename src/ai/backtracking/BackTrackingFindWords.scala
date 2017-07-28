package ai.backtracking

import scala.util.Success
import scala.util.Try
import scala.util.Failure

class BackTrackingFindWords {
  
  	val board = Array(
								    Array('R', 'L', 'D'),
								    Array('U', 'O', 'E'),
								    Array('C', 'S', 'O')
								)
                                                  
  	
  	val words = Array("CODE", "SOLO", "RULES", "COOL")
  	
  	
  	def generate(current: Array[(Char, Int, Int)]): Array[(Int, Int)] = {
  		
  			if (current.isEmpty) {
  				(for {
  					i <- 0 until board.size;
  					j <- 0 until board(i).size
  				} yield (i, j)).toArray
  			} else {
  				val last = current.last
  				val i = last._2
  				val j = last._3
  				Array((i + 1, j + 1), (i + 1, j), (i, j + 1), (i - 1, j + 1),
  							(i + 1, j - 1), (i - 1, j - 1), (i - 1, j), (i, j - 1))
  			}
  	
  	}                                         
  	
  	def findSolutions(current: Array[(Char, Int, Int)]): Array[Array[(Char, Int, Int)]] = {
  	
        var solutions = Array.empty[Array[(Char, Int, Int)]]
        val word = current.map(a => a._1).mkString
        if (words.contains(word)) {
           solutions = solutions :+ current
        }
        
        for (a <- generate(current)){
        		
        		Try(board(a._1)(a._2)) match {
        			case Success(c) => {
        					val index = current.size
	                if(current.filter(x => x._2 == a._1 && x._3 == a._2).isEmpty && !words.filter(a => index < a.size && a.charAt(index) == c).isEmpty){
	                    val possibleSolutions =	 findSolutions(current :+ (c, a._1, a._2));
	                    for(sol <- possibleSolutions) solutions = solutions :+ sol;
	                }
        			}
        			case Failure(_) =>
        		}
        }

        
        solutions
	}                                         
	
	
	findSolutions(Array.empty[(Char, Int, Int)]).map(a => a.map(b => b._1).mkString).distinct.sorted.toArray
  	
}