package week_2

class Rational(x: Int, y: Int) {

	require(y != 0, "Denominator must be non-zero")

	def this(x: Int) = this(x, 1)

	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
	private val g = gcd(x, y)

	val numerator = x
	val denominator = y

	def <(that: Rational): Boolean = numerator * that.denominator < denominator * that.numerator

	def max(that: Rational): Rational = if (this < that) that else this

	def +(that: Rational): Rational = {
			new Rational(
					numerator * that.denominator + that.numerator * denominator,
					denominator * that.denominator)
	}

	def unary_- : Rational = new Rational(-numerator, denominator)

			def -(that: Rational): Rational = this + -that

			override def toString = numerator / g + "/" + denominator / g

}
