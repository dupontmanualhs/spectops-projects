import org.scalatest.{ FunSuite, Matchers }

class TestMyList extends FunSuite with Matchers {
  val emptyInts: MyList[Int] = MyEmpty
  
  test("empty Int list") {
    emptyInts.length shouldEqual 0
    evaluating { emptyInts(0) } should produce[IndexOutOfBoundsException]
  }
  
}