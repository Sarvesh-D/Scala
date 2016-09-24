package week_2

object excercise {

  def gcd(x: Int, y: Int): Int =
    if (y == 0) x else gcd(y, x % y)              //> gcd: (x: Int, y: Int)Int

  def factorial(x: Int): Int = {
    def loop(acc: Int, x: Int): Int =
      if (x == 0) acc
      else loop(acc * x, x - 1)
    loop(1, x)
  }                                               //> factorial: (x: Int)Int
  
  factorial(5)                                    //> res0: Int = 120

}