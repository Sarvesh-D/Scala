package week_3

object patterns {

  def eval(e: Expression): Double = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
    case Product(e1, e2) => eval(e1) * eval(e2)
  }                                               //> eval: (e: week_3.patterns.Expression)Double
  
  def show(e: Expression): String = e match {
  	case Number(n) => n.toString()
  	case Sum(e1, e2) => "(" + show(e1) + " + " + show(e2) + ")"
  	case Product(e1, e2) => show(e1) + " * " + show(e2)
  }                                               //> show: (e: week_3.patterns.Expression)String

  trait Expression

  case class Number(n: Double) extends Expression

  case class Sum(x: Expression, y: Expression) extends Expression

  case class Product(x: Expression, y: Expression) extends Expression

  val answer = show(Product(Sum(Number(3), Number(4)),Number(3))) + " = " + eval(Product(Sum(Number(3), Number(4)),Number(3)))
                                                  //> answer  : String = (3.0 + 4.0) * 3.0 = 21.0
  show(Sum(Product(Sum(Number(3), Number(4)),Number(3)), Number(10)))
                                                  //> res0: String = ((3.0 + 4.0) * 3.0 + 10.0)

}