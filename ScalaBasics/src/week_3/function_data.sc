package week_3

import week_2.Rational

object function_data {
  val x = new Rational(1, 2)                      //> x  : week_2.Rational = 1/2
  val y = new Rational(1, 3)                      //> y  : week_2.Rational = 1/3
  val z = new Rational(64,1280)                   //> z  : week_2.Rational = 1/20
  x - y - z                                       //> res0: week_2.Rational = 7/60
  x < z                                           //> res1: Boolean = false
  -y                                              //> res2: week_2.Rational = 1/-3
  val xs = new Cons(1, new Cons(2, Nil))          //> xs  : week_3.Cons[Int] = [1,2,NIL]
 	xs.prepend(88)                            //> res3: week_3.List[Int] = [88,1,2,NIL]
}