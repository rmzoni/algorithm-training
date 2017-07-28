package ai.backtracking

class PossibleWaysClimbStaircase {
 
  def resolve(n: Int, k: Int): Array[Array[Int]] = {
    
    def findSolutions( current: Array[Int]): Array[Array[Int]] = {
        var solutions = Array.empty[Array[Int]]
        if (current.sum == n) {
            return Array(current);
        }
        else {
            for (a <- 1 to k){
                val newState = current :+ a
                if(newState.sum <= n){
                    val possibleSolutions = findSolutions(newState);
                    for(sol <- possibleSolutions) solutions =  solutions :+ sol;
                }
            }

        }
        solutions
	}

	findSolutions(Array())
}

  
}