package complex

import org.scalatest._

class ComplexSpec extends FlatSpec with Matchers {

  /* After you complete a method, uncomment the tests for that method
  */
  
  /*
  "A Complex Number" should "display a string in the form ax + bi" in {
    (new Complex(7, 2)).toString should be ("7.0 + 2.0i")
    (new Complex(2, 3)).toString should be ("2.0 + 3.0i")
    (new Complex(44, 20)).toString should be ("44.0 + 20.0i")
  }
  */
  
  /*
  it should "properly display subtraction and coeffs of 1 and 0" in {
    (new Complex(2, 0)).toString should be ("2.0")
    (new Complex(0, 2)).toString should be ("2.0i")
    (new Complex(3, -4)).toString should be ("3.0 - 4.0i")
    (new Complex(-4, 3)).toString should be ("-4.0 + 3.0i")
    (new Complex(1, 1)).toString should be ("1.0 + i")
    (new Complex(1, -1)).toString should be ("1.0 - i")
    (new Complex(0, -2)).toString should be ("-2.0i")
  }
  */
    
  val com1 = new Complex(2, 0)
  val com2 = new Complex(4, -1)
  val com3 = new Complex(-5, -4)
  val com4 = new Complex(3, 8)
   
  /*
  it should "add to other Complex Numbers" in {
    (com1 + com2) should be (new Complex(6, -1))
    (com1 + com3) should be (new Complex(-3, -4))
    (com1 + com4) should be (new Complex(5, 8))
    (com2 + com3) should be (new Complex(-1, -5))
    (com2 + com4) should be (new Complex(7, 7))
    (com3 + com4) should be (new Complex(-2, 4))
    (com1 + com3) should be (com3 + com1)
    (com2 + com4) should be (com4 + com2)
  }
  */
  
  /*
  it should "subtract from other Complex Numbers" in {
    (com1 - com2) should be (new Complex(-2, 1))
    (com1 - com3) should be (new Complex(7, 4))
    (com1 - com4) should be (new Complex(-1, -8))
    (com2 - com3) should be (new Complex(9, 3))
    (com2 - com4) should be (new Complex(1, -9))
    (com3 - com4) should be (new Complex(-8, -12))
  }
  */
  
  /*
  it should "multiply other Complex Numbers" in {
    (com1 * com2) should be (new Complex(8, -2))
    (com1 * com3) should be (new Complex(-10, -8))
    (com1 * com4) should be (new Complex(6, 16))
    (com2 * com3) should be (new Complex(-24, -11))
    (com2 * com4) should be (new Complex(20, 29))
    (com3 * com4) should be (new Complex(17, -52))
  }
  */
  
  /*
  it should "produce a conjugate" in {
    com1.conjugate should be (new Complex(2, 0))
    com2.conjugate should be (new Complex(4, 1))
    com3.conjugate should be (new Complex(-5, 4))
    com4.conjugate should be (new Complex(3, -8))
  }
  */
  
  val com5 = new Complex(0, 1)
  val com6 = new Complex(3, 4)
  val com7 = new Complex(8, 6)
  
  /*
  it should "divide other Complex Numbers" in {
    (com5 / com6) should be (new Complex(.16, .12))
    (com7 / com5) should be (new Complex(6, -8))
    (com6 / com7) should be (new Complex(.48, .14))
  }
  */
  
  /*
  it should "produce the magnitude" in {
    com1.magnitude should be (2)
    com6.magnitude should be (5)
    com7.magnitude should be (10)
  }
  */
  
  // Extra Credit!!!
  // You may need to add some import statements for this one
  /*
  it should "be easily writeable with implicits" in {
    (1 + 2.i) should be (new Complex(1, 2))
    (4 - 25.i) should be (new Complex(4, -25))
    (-2.i) should be (new Complex(0, -2))
  }*/
}