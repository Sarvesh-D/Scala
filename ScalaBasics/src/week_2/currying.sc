package week_2

object currying {

  def cube(x: Int): Int = x * x * x               //> cube: (x: Int)Int

  // Function that takes function as arg
  // and returns a function can be used
  // for currying
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    }
    sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int
  
  // scala way for doing same as above
  def sumModified(f: Int => Int)(a: Int, b: Int): Int = {
  	if(a > b) 0
  	else f(a) + sumModified(f)(a + 1, b)
  }                                               //> sumModified: (f: Int => Int)(a: Int, b: Int)Int
  
	// using middlemen function sumCubes
  def sumCubes = sum(cube)                        //> sumCubes: => (Int, Int) => Int
  sumCubes(1, 30)                                 //> res0: Int = 216225
  
  // scala way without middlemen --> Currying
  sum(cube)(1,3)                                  //> res1: Int = 36

}