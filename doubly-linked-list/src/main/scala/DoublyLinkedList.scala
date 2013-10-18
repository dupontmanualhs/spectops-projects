package linkedList

class DoublyLinkedList[T] {
  private var sentinel: Node = new Node(null.asInstanceOf[T], null, null)
  sentinel.prev = sentinel
  sentinel.next = sentinel  

  override def toString(): String = {
    s"[${sentinel.next.elems}]"
  }
  
  def length(): Int = {
    ???
  }
  
  def addAtBeginning(obj: T) {
    // this works, but it's better to just use the add that takes an index
    val newHead = new Node(obj, this.sentinel, this.sentinel.next)
    this.sentinel.next = newHead
    newHead.next.prev = newHead
  }
  
  def addAtEnd(obj: T) {
    // again, use add that takes an index
    val newTail = new Node(obj, this.sentinel.prev, this.sentinel)
    this.sentinel.prev = newTail
    newTail.prev.next = newTail
  }
  
  def add(index: Int, obj: T) {
    
  }
  
  def apply(index: Int): T = {
    ???
  }
  
  def set(index: Int, obj: T): T = {
    ???
  }
  
  def remove(index: Int): T = {
    ???
  }
  
  def contains(obj: T): Boolean = {
    ???
  }
  
  def indexOf(obj: T): Int = {
    ???
  }

  private class Node(var data: T, var prev: Node, var next: Node) {
    def elems(): String = {
      if (this == sentinel) ""
      else if (this.next == sentinel) s"${this.data}"
      else s"${this.data}, ${this.next.elems}"
    }
  }
}
