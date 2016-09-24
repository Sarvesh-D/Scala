package week_5

object CollectionUtils {
  
  /**
   * Takes a list of type T and transforms it to list of type U
   * by applying given function to each element of the list
   * TODO convert map function using for expression
   */
  def map[T,U](xs: List[T])(f: T => U): List[U] = xs match {
    case Nil => Nil
    case y :: ys => f(y) :: map(ys)(f)
  }
  
  /**
   * Takes a list of type T and returns a filtered list containing
   * elements that pass the given function
   * TODO convert filter function using for expression
   */
  def filter[T](xs: List[T])(p: T => Boolean): List[T] = xs match {
    case Nil => Nil
    case y :: ys => if(p(y)) y :: filter(ys)(p) else filter(ys)(p) 
  }
  
  /**
   * packs n consecutive similar elements of list
   */
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case y :: ys =>
      val (first, rest) = xs span { x => x == y }
      first :: pack(rest)
  }
  
  /**
   * packs an element 'n' of list along with count for which 'n' appears consecutively
   */
  def encode[T](xs: List[T]): List[(T, Int)] = map(pack(xs))(ys => (ys.head, ys.length))
}