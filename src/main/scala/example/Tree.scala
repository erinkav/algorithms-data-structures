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
  Graph
}
