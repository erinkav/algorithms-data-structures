package example

import scala.collection.mutable.ListBuffer

class Node (var input: Any){
  var value: Any = input
  var left: Option[Node]  = None
  var right: Option[Node] = None
  var children: ListBuffer[Node] = ListBuffer()

  def insertLeft(child: Node): Unit = {
    if(left == None) {
      left = Some(child)
    } else {
      child.left = left
      left = Some(child)
    }
  }

  def insertRight(child: Node): Unit = {
    if(right == None) {
      right = Some(child)
    } else {
      child.right = right
      right = Some(child)
    }
  }
}

class ListNode(var input: Int) {
  var value: Int = input
  var left = List()
  var right = List()
}


class ListTree(var input: Any) {
  val root = ListBuffer(input, ListBuffer(), ListBuffer())

  def insertLeft(value: Any): Unit = {
    val subtree = root(1)
    root(1) = ListBuffer(value, subtree, ListBuffer())
  }

  def insertRight(value: Any): Unit = {
    val subtree = root(2)
    root(2) = ListBuffer(value, subtree, ListBuffer())
  }

  def getRootVal(): Any= {
    root(0)
  }

  def setRootVal(value: Any): Unit = {
    root(0) = value
  }

  def getLeftChild(): Any = {
    root(1)
  }

  def getRightChild(): Any = {
    root(2)
  }

}

object TreeTraversals {
  def preorder(node: Node): Unit = {
    if(node != null) {
      print(node.value)
      preorder(node.left.getOrElse(null))
      preorder(node.right.getOrElse(null))
    }
  }

  def postorder(node: Node): Unit = {
    if(node != null) {
      postorder(node.left.getOrElse(null))
      postorder(node.right.getOrElse(null))
      print(node.value)
    }
  }

  def inorder(node: Node): Unit = {
    if(node != null) {
      inorder(node.left.getOrElse(null))
      print(node.value)
      inorder(node.right.getOrElse(null))
    }
  }
}

//object binaryTreeOperations{
//  def getNextFreeNode(currNode: Node): Node = {
//    if(currNode.left != None) {
//      println(currNode)
//      getNextFreeNode(currNode.left.get)
//    } else if(currNode.right != None) {
//      println(currNode)
//      getNextFreeNode(currNode.right.get)
//    } else {
//      currNode.left.get
//    }
//  }
//
//  def constructBinaryTreeFromList(treeList: List[Any]): Node = {
//    var root: Node = null
//    var currNode: Node = null
//    treeList.foreach(value => {
//      if(value != null) {
//        if(root == null) {
//          println("set root node")
//          root = new Node(value)
//          currNode = root
//        } else {
//          println("root node is set, get next")
//          var nullNode = getNextFreeNode(root)
//          nullNode = new Node(value)
//        }
//      }
//    })
//
//    root
//  }
//}

object minTreeDepth {
  def setChildren(childList: List[Any], counter: Int): Int = {
    def children = childList.slice(0, 2)

    childList.size match {
      case 0 => counter
      case 1 => setChildren(childList.slice(0, 2), counter + 1)
      case 2 | 3 => {
        setChildren(childList.slice(2, childList.size), counter + 1)
      }
      case _ => {
        setChildren(childList.slice(2, childList.size), counter + 1)
        setChildren(childList.slice(4, childList.size), counter + 1)
      }
    }
  }

  def main(treeList: List[Any]): Int = {
    setChildren(treeList.slice(1, treeList.size), 1)
  }

}

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.PriorityQueue
import scala.collection.mutable.Map

object GraphTraversals {

  def networkDelayTime(times: List[List[Int]], N: Int, K: Int): Int = {
    //    N Nodes from 1 -> N
    //    given a list of travel times where u is the source node, v the target node and w the travel times
    //    K is the node that it starts as
    //    How long until all nodes recieve a signal
    1

  }
  def diff(t2: (String,Int)) = t2._2

//  def calculateDistances(graph: Map[String, Map[String, Int]], startingVertex: String): Map[String, Int] = {
//    val distances = graph.map({case (k, v) => k -> Float.PositiveInfinity})
//    println(distances)
//    val pq = new PriorityQueue[(String, Int)]()(Ordering.by(diff))
//    distances(startingVertex) = 0
//
//    val entryLookup = Map[String, (Int, String)]()
//
//    for ((vertex, distance) <- distances) {
//      println(vertex, distance)
//      val entry = (distance, vertex)
//      entryLookup(vertex) = entry
//      pq.enqueue(entry)
//    }
//
//    while(pq.size > 0) {
//      val currentDistance, currentVertex = pq.dequeue()
//      for ((neighbor, neighborDistance) <- graph(currentVertex)) {
//        val distance = distances(currentVertex) + neighborDistance
//        if(distance < distances(neighbor)) {
//          distances(neighbor) = distance
//          entryLookup(neighbor)(0) = distance
//        }
//      }
//    }
//
//    return distances
//
//  }
}

object PriorityQueue {
  //
}

object BinaryHeap {
  // Def: Complete Binary Tree that follows the heap priority if at every node, children are larger than the node
  val heap = ListBuffer[Int](0)
  def pop(): Int = {
    heap.remove(0)
  }
  def add(value: Int): Unit = {
    heap.append(value)
    var compIndex = heap.size - 1
    if(compIndex > 1) {
      while(heap(compIndex) > value || compIndex >= 1) {
        heap(compIndex + 1) = heap(compIndex)
        heap(compIndex) = value

      }

    }
  }
}

object Dijkstra  {
  def main(graph: Map[String, Map[String, Any]], origin: String): Map[String, Any] = {
    val distances = Map[Any, Any]()
    val pq = List((0, origin))
    val visited = Map()
    while(pq.nonempty) {
      val distance = pq.pop()._1
      val vertex = pq.pop()._2

      for(vertex in visited) {
        visted(vertex) = true
        distances(vertex) = distance
        for(neighbor, edge_weight in graph(vertex)) {
          pq.push(pq, distance + weight, neighbor)
        }
      }
    }
  }
  return distances

}

object Tree extends App {
  val root = new Node(1)

  root.insertLeft(new Node(2))
  root.insertRight(new Node(3))
  root.left.get.insertLeft(new Node(4))
  root.left.get.insertLeft(new Node(5))
  root.right.get.insertRight(new Node(6))

  TreeTraversals.postorder(root)
  println("postorder")

  TreeTraversals.preorder(root)
  println("preorder")

  TreeTraversals.inorder(root)
  println("inorder")

  minTreeDepth.main(List(3,9,20,null,null,15,7))
  val exampleGraph = Map('U' -> Map('V'-> 2, 'W'-> 5, 'X'-> 1),
    'V' -> Map('U'-> 2, 'X'-> 2, 'W'-> 3),
    'W' -> Map('V'-> 3, 'U'-> 5, 'X'-> 3, 'Y'-> 1, 'Z'-> 5),
    'X' -> Map('U'-> 1, 'V'-> 2, 'W'-> 3, 'Y'-> 1),
    'Y' -> Map('X'-> 1, 'W'-> 1, 'Z'-> 1),
    'Z' -> Map('W'-> 5, 'Y'-> 1))
  GraphTraversals

  BinaryHeap.add(1)
  BinaryHeap.add(2)

  Dijkstra.main()
}
