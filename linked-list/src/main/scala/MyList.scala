abstract class MyList[+T] {
  def head: T
  def tail: MyList[T]
  def isEmpty: Boolean
  def length: Int
  def contains(elem: Any): Boolean
  def indexOf(elem: Any): Int
  def apply(index: Int): T
  def +:[U >: T](elem: U): MyList[U]
}

case object MyEmpty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException("head of empty list")
  def tail: MyList[Nothing] = throw new NoSuchElementException("tail of empty list")
  def isEmpty: Boolean = true
  def length: Int = 0
  def contains(elem: Any) = false
  def indexOf(elem: Any) = -1
  def apply(index: Int): Nothing = throw new IndexOutOfBoundsException("index of empty list")
  def +:[T](elem: T): MyList[T] = NonEmpty(elem, MyEmpty)
}

case class NonEmpty[T](head: T, tail: MyList[T]) extends MyList[T] {
  def isEmpty: Boolean = false
  def length: Int = 1 + tail.length
  def contains(elem: Any): Boolean = head == elem || tail.contains(elem)
  def indexOf(elem: Any) = {
    if (head == elem) 0
    else tail.indexOf(elem) match {
      case -1 => -1
      case tailIndex: Int => tailIndex + 1
    }
  }
  def apply(index: Int) = {
    if (index == 0) head
    else tail(index - 1)
  }
  def +:[U >: T](elem: U): MyList[U] = NonEmpty(elem, this)
}