package week_5

object NumberUtils {
  
  def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0)
  
  def nMultilpesOf(n: Int, m: Int): List[Int] = from(1).take(n).toList map (_ * m)
  
  /**
   * returns lazily initialised infinite sequence starting from n
   */
  def from(n: Int): Stream[Int] = n #:: from(n + 1) 
  
}