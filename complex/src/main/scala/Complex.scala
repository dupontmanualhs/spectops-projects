package complex

class Complex(val real: Double, val imag: Double) {
  // Put all your methods in here

  override def equals(x: Any) = x match {
    case c: Complex => real == c.real && imag == c.imag
    case _ => false
  }
}