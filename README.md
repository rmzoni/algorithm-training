# algorithm-training
Algorithm technique training using scala language!!

## Backtracking
Backtracking is a technique used to build up to a solution to a problem incrementally. 
These "partial solutions" can be phrased in terms of a sequence of decisions. 
Once it is determined that a "partial solution" is not viable (i.e. no subsequent decision can convert it into a solution) then the backtracking algorithm retraces its step to the last viable "partial solution" and tries again.

Visualizing the decisions as a tree, backtracking has many of the same properties of depth-first search. 
The difference is that depth-first search will guarantee that it visits every node until it finds a solution, whereas backtracking doesn't visit branches that are not viable.

Because backtracking breaks problems into smaller subproblems, it is often combined with dynamic programming, or a divide-and-conquer approach.

Problems are solved in ai.backtracking package.
