package week_3

trait List[+T] {
  
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T](elem: U) : List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  
  override def isEmpty = false
  override def toString = listAsArray(this)
  
  private def listAsArray(xs: List[T]) = {
    def loop(xs: List[T], acc: String): String = {
      if(xs.isEmpty) acc + "NIL]"
      else loop(xs.tail, acc + xs.head + ",")
    }
    loop(xs, "[")
  }
}

object Nil extends List[Nothing] {
  
  override def isEmpty = true
  override def head: Nothing = throw new NoSuchElementException("Nil.head")
  override def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  override def toString = "[NIL]"
  
}

object test {
  val xs = new Cons(1, new Cons(2, Nil))
  println(xs)
}