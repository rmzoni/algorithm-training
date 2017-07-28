# algorithm-training
Algorithm techniques training using scala language!!!

## Backtracking
Backtracking is a technique used to build up to a solution to a problem incrementally. 
These "partial solutions" can be phrased in terms of a sequence of decisions. 
Once it is determined that a "partial solution" is not viable (i.e. no subsequent decision can convert it into a solution) then the backtracking algorithm retraces its step to the last viable "partial solution" and tries again.

Visualizing the decisions as a tree, backtracking has many of the same properties of depth-first search. 
The difference is that depth-first search will guarantee that it visits every node until it finds a solution, whereas backtracking doesn't visit branches that are not viable.

Because backtracking breaks problems into smaller subproblems, it is often combined with dynamic programming, or a divide-and-conquer approach.

Problems
- Find words
- N-Queens
- Possible Ways Climb a Staircase

Problems are solved in ai.backtracking package.

## Linked Lists
A linked list is a sequential-access data structure used for storing ordered elements. They prioritize quick and easy data insertion and deletion over item lookup. All linked lists are collections of node data structures that are connected by pointers - that's where the "link" in "linked list" comes from.

```scala
class ListNode[T](x : T) {
  var value: T = x
  var next: Option[ListNode[T]] = None
}

```

Problems
- Merge Linked Lists
- Reverse in a group of k elements

Problems are solved in ai.linkedlists package

## Tree
A tree is a data structure composed of parent and child nodes. Each node contains a value and a list of references to its child nodes. Trees borrow a lot of language from nature (each tree has a root node and leaf nodes) and from family trees (there are parent and child nodes).

```scala
class Tree[T](x: T) {
    var value: T = x
    var left: Option[Tree[T]] = None
    var right: Option[Tree[T]] = None
}
```

Problems
- Symmetric Tree
- Is Subtree
- Delete from an Binary Search Tree

Problems are solved in ai.tree package


## Depth-First Search & Breadth-First Search
Depth-first search (DFS) and breadth-first search (BFS) are common algorithms for searching trees or graphs.

In DFS, you start at the root of the tree (or a selected node if it’s a graph) and search as far as possible along each branch before backtracking. DFS is great for searching trees that are deeper than they are wide.

In BFS, on the other hand, you start at the root of the tree (or a selected node in a graph) and search each subsequent level of nodes before moving on to the next level. BFS is great for searching trees that are wider than they are deep. 

Problems
- BFS - Traverse Tree
- DFS - Digit Tree Sum

Problems are solved in ai.bfs_dfs package

# Sorting
Sorting algorithms are used to put the elements of an array in a certain order, generally using a comparison function to determine order (a generalization of less than). Some comparison functions will allow for ties between different objects. A stable sorting algorithm will guarantee that if two elements "tie", then whichever element occured first in the original array will also occur first in the sorted array. An unstable sorting algorithm will only guarantee that the final elements are in order, and makes no guarantee about the order of "tied" elements.

- Quick sort
- Merge sort

Problems
- Merge Sort

Problems are solved in ai.sorting package