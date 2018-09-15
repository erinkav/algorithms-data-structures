package example

import scala.collection.mutable.Queue
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

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
}

object Graph {
  val root = new Node(1)
  root.children = ListBuffer(new Node(2), new Node(3), new Node(4))
  root.children(0).children = ListBuffer(new Node(5), new Node(6), new Node(7))
  root.children(1).children = ListBuffer(new Node(8), new Node(9), new Node(10))


  val searchTools = new GraphSearch()
  searchTools.depthFirstSearch(root)
}