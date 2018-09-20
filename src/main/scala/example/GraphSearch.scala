package example

import scala.collection.mutable.Queue
import scala.collection.mutable.{ArrayBuffer, ListBuffer, Set}

class GraphSearch {
  def process(node: Node): Unit = {
    println(node.value)
  }
  // BFS:
  // When you think your node is at the top of the tree
  //
  def breadthFirstSearch(root: Node): Unit = {
    val queue = Queue[Node]()
    queue.enqueue(root)
    while(queue.size > 0) {
      val node = queue.dequeue()
      process(node)
      for(child <- node.children) {
        queue.enqueue(child)
      }
    }
  }
  // DFS:
  // When you're looking for a leaf node
  def depthFirstSearch(root: Node): Unit = {
    val stack = ArrayBuffer[Node]()
    stack.append(root)
    while(stack.size > 0) {
      val node = stack.remove(stack.size - 1)
      process(node)
      for(child <- node.children) {
        stack.append(child)
      }
    }
  }

  def isLeaf(node: Node): Boolean = {
    node.children.size == 0
  }

//  def minimumDepth(root: Node): Int = {
//    val queue = Queue[(Node, Int)]()
//    queue.enqueue((root, 1))
//    while(queue.size > 0) {
//      val value = queue.dequeue()
//      val node = value._1
//      val depth = value._2
//      println(depth)
//      if(isLeaf(node)) {
//         depth
//      } else {
//        for(child <- node.children) {
//          queue.enqueue((child, depth + 1))
//        }
//      }
//    }
//  }

  def checkValid(buckets: (Int, Int), target: Int): Boolean = {
    buckets._1 > target
  }


//  def dieHardProblem(A: Int, B: Int, C: Int): Boolean = {
//    if(A < finalAmount && B < finalAmount) {
//      throw new Exception("Impossible")
//    } else {
//      val alreadyTriedCombos = Set()
//      // for 0, 0
//      val root = (0, 0)
//        // fill A
////        checkValid((A, ))
//            // Check if A or B == C
//        // fill B
//            // Check if A or B == C
//        // pour A -> B
//          // Check if A or B == C
//        // pour B -> A
//          // Check if A or B == C
//        // dump B
//          // Check if A or B == C
//        // dump A
//          // Check if A or B == C
//    }
//    true
//  }

//  def runReversals(pancakeStack: ListBuffer[Int], target: ListBuffer[Int], checkedSet: Set[ListBuffer[Int]], counter: Int): Int = {
//    for(index <- List(0 -> pancakeStack.size)) yield {
//      // reverse 0 -> index
//      val flippedPancakes = pancakeStack.slice(0, index).reverse ++ pancakeStack.slice(index, pancakeStack.size)
//      if(flippedPancakes == target) {
//        counter
//      } else if(!checkedSet.contains(flippedPancakes)) {
//        checkedSet.add(flippedPancakes)
//        runReversals(flippedPancakes, target, checkedSet, counter + 1)
//      }
//    }
//  }

  def pancakeProblem(pancakeStack: ListBuffer[Int]): Int = {
    var index = 0
    var results = pancakeStack.sortWith(_ < _)
    val checkedSet: Set[ListBuffer[Int]] = Set()


//    runReversals(pancakeStack, results, checkedSet, 0)

    1
  }

}

object Graph {
  val root = new Node(1)
  root.children = ListBuffer(new Node(2), new Node(3), new Node(4))
  root.children(0).children = ListBuffer(new Node(5), new Node(6), new Node(7))
  root.children(1).children = ListBuffer(new Node(8), new Node(9), new Node(10))


  val searchTools = new GraphSearch()
  println(searchTools.pancakeProblem(ListBuffer(3,4, 8)))
//  println("returned", searchTools.minimumDepth(root))
}