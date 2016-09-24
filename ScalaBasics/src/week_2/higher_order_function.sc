package week_2

object higher_order_function {

  def cube(x: Int): Int = x * x * x               //> cube: (x: Int)Int

	// Function that takes function as arg
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(x: Int, acc: Int): Int = {
      if (x > b) acc
      else loop(x + 1, acc + f(x))
    }
    
    loop(a, 0)

  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
                                                  //> sumCubes: (a: Int, b: Int)Int
  
  sumCubes(1, 3)                                  //> res0: Int = 36

}