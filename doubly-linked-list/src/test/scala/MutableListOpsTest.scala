import org.scalatest.{ BeforeAndAfter, FunSuite, Matchers, ParallelTestExecution }

abstract class MutableListOpsTest[T](ctor: () => MutableListOps[String]) extends FunSuite 
    with Matchers with BeforeAndAfter with ParallelTestExecution {
  
  var list: MutableListOps[String] = _
  
  before {
    this.list = ctor()
  }
  
  test("empty list") {
    list.length shouldEqual 0
    list.toString shouldEqual "[]"
    val e1 = evaluating { list(-1) } should produce[IndexOutOfBoundsException]
    e1.getMessage shouldEqual "index: -1, length: 0"
    val e2 = evaluating { list(0) } should produce[IndexOutOfBoundsException]
    e2.getMessage shouldEqual "index: 0, length: 0"
    val e3 = evaluating { list(3) } should produce[IndexOutOfBoundsException]
    e3.getMessage shouldEqual "index: 3, length: 0"
    val e4 = evaluating { list.remove(0) } should produce[IndexOutOfBoundsException]
    e4.getMessage shouldEqual "index: 0, length: 0"
    val e5 = evaluating { list.set(0, "a") } should produce[IndexOutOfBoundsException]
    e5.getMessage shouldEqual "index: 0, length: 0"
  }
  
  test("add at beginning") {
    list.addAtBeginning("a")
    list.length shouldEqual 1
    list.toString shouldEqual "[a]"
    list.addAtBeginning("b")
    list.length shouldEqual 2
    list.toString shouldEqual "[b, a]"
    list.addAtBeginning("c")
    list.length shouldEqual 3
    list.toString shouldEqual "[c, b, a]"
  }
  
  test("add at end") {
    list.addAtEnd("a")
    list.length shouldEqual 1
    list.toString shouldEqual "[a]"
    list.addAtEnd("b")
    list.length shouldEqual 2
    list.toString shouldEqual "[a, b]"
    list.addAtEnd("c")
    list.length shouldEqual 3
    list.toString shouldEqual "[a, b, c]"
  }
  
}