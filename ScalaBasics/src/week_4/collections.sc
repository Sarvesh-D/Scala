package week_4

import math.Ordering

object collections {

	// Takes a list of type T and based on the type T automatically infers the Ordering
	// ord.lt --> sorts the list in asc order
	// ord.gt --> sorts the list in desc order
	def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
		val n = xs.length / 2
		if(n == 0) xs
		else {
			def merge(xs1: List[T], ys1: List[T]): List[T] = (xs1, ys1) match {
				case(Nil, ys1) => ys1
				case(xs1, Nil) => xs1
				case(x :: xt, y :: yt) => {
					if(ord.lt(x, y)) x :: merge(xt, ys1)
					else y :: merge(xs1, yt)
				}
			}
			val (xs1, ys1) = xs splitAt n
			merge(msort(xs1), msort(ys1))
		}
	
	}                                         //> msort: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]


  var nums = List(1,4,2,-3,45,5)                  //> nums  : List[Int] = List(1, 4, 2, -3, 45, 5)
  var nums_updated = nums updated(2, 99)          //> nums_updated  : List[Int] = List(1, 4, 99, -3, 45, 5)
  nums ::: nums_updated                           //> res0: List[Int] = List(1, 4, 2, -3, 45, 5, 1, 4, 99, -3, 45, 5)
  //nums :: List(444)
  nums.isEmpty                                    //> res1: Boolean = false
  nums(5)                                         //> res2: Int = 5
  nums.take(3)                                    //> res3: List[Int] = List(1, 4, 2)
  nums.drop(3)                                    //> res4: List[Int] = List(-3, 45, 5)
  
  msort(nums)                                     //> res5: List[Int] = List(-3, 1, 2, 4, 5, 45)
  val fruits = List("apple","pineapple","custard apple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, custard apple, orange, banan
                                                  //| a)
  msort(fruits)                                   //> res6: List[String] = List(apple, banana, custard apple, orange, pineapple)
  
  nums match {
  	case p :: ps => p
  }                                               //> res7: Int = 1
}