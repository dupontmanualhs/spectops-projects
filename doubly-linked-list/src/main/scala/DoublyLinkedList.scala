trait MutableListOps[T] {
  def length(): Int
  def addAtBeginning(obj: T): Unit
  def addAtEnd(obj: T): Unit
  def add(index: Int, obj: T): Unit
  def apply(index: Int): T
  def set(index: Int, obj: T): T
  def remove(index: Int): T
  def contains(obj: T): Boolean
  def indexOf(obj: T): Int
}

class DoublyLinkedList[T] extends MutableListOps[T]{
  private var sentinel: Node = new Node(null.asInstanceOf[T], null, null)
  sentinel.prev = sentinel
  sentinel.next = sentinel
  // instead of counting, keep track of length
  private var len: Int = 0

  override def toString(): String = {
    s"[${this.sentinel.next.elems}]"
  }
  
  def length(): Int = {
    this.len
  }
  
  def addAtBeginning(obj: T) {
    this.add(0, obj)
  }
  
  def addAtEnd(obj: T) {
    this.add(this.len, obj)
  }
  
  private def checkIndex(index: Int, small: Int, big: Int) {
    if (index < small || index > big) throw new IndexOutOfBoundsException(s"index: $index, length: ${this.len}")
  }
  
  private def nNodesAfter(start: Node, n: Int): Node = {
    if (n == 0) start
    else nNodesAfter(start.next, n - 1)
  }
  
  private def nNodesBefore(start: Node, n: Int): Node = {
    if (n == 0) start
    else nNodesBefore(start.prev, n - 1)
  }
  
  private def nthNode(n: Int) = {
    // legal values are -1 (the sentinel) to this.len (also the sentinel)
    // finds the given node by going from the closest end
    if (n <= this.len / 2) nNodesAfter(this.sentinel, n + 1)
    else nNodesBefore(this.sentinel, this.len - n)
  }
  
  def add(index: Int, obj: T) {
    checkIndex(index, 0, this.len)
    val nodeBefore: Node = nthNode(index - 1)
    val newNode = new Node(obj, nodeBefore, nodeBefore.next)
    nodeBefore.next = newNode
    newNode.next.prev = newNode
    this.len += 1
  }
  
  def apply(index: Int): T = {
    checkIndex(index, 0, this.len - 1)
    nthNode(index).data
  }
  
  def set(index: Int, obj: T): T = {
    checkIndex(index, 0, this.len - 1)
    val nodeToChange = nthNode(index)
    val oldData = nodeToChange.data
    nodeToChange.data = obj
    oldData
  }
  
  def remove(index: Int): T = {
    checkIndex(index, 0, this.len - 1)
    val nodeToRemove = nthNode(index)
    val nodeBefore = nodeToRemove.prev
    val nodeAfter = nodeToRemove.next
    nodeBefore.next = nodeAfter
    nodeAfter.prev = nodeBefore
    this.len -= 1
    nodeToRemove.data
  }
  
  def contains(obj: T): Boolean = {
    indexOf(obj) != -1
  }
  
  def indexOf(obj: T): Int = {
    def checkNode(index: Int, node: Node): Int = {
      if (node == this.sentinel) -1
      else if (node.data == obj) index
      else checkNode(index + 1, node.next)
    }
    checkNode(0, this.sentinel.next)
  }

  private class Node(var data: T, var prev: Node, var next: Node) {
    def elems(): String = {
      if (this == sentinel) ""
      else if (this.next == sentinel) s"${this.data}"
      else s"${this.data}, ${this.next.elems}"
    }
  }
}
