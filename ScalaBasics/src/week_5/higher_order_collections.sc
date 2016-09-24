package week_5

object higher_order_collections {

  val nums = List(-1, -2, -3, -5, 1, 2, 3, 4, 5, 6)
                                                  //> nums  : List[Int] = List(-1, -2, -3, -5, 1, 2, 3, 4, 5, 6)
  val squareNums = CollectionUtils.map(nums)(x => x * x)
                                                  //> squareNums  : List[Int] = List(1, 4, 9, 25, 1, 4, 9, 16, 25, 36)
  val singleDigitSquares = CollectionUtils.filter(nums)(x => x > 0)
                                                  //> singleDigitSquares  : List[Int] = List(1, 2, 3, 4, 5, 6)

  nums filter (x => x < 0)                        //> res0: List[Int] = List(-1, -2, -3, -5)
  nums takeWhile { x => x < 0 }                   //> res1: List[Int] = List(-1, -2, -3, -5)
  nums dropWhile { x => x < 0 }                   //> res2: List[Int] = List(1, 2, 3, 4, 5, 6)
  nums span { x => x < 0 }                        //> res3: (List[Int], List[Int]) = (List(-1, -2, -3, -5),List(1, 2, 3, 4, 5, 6))
                                                  //| 
  nums reduceRight(_ + _)                         //> res4: Int = 10

  val letters = List("a", "a", "a", "a", "b", "b", "b", "c", "c", "c", "c", "a")
                                                  //> letters  : List[String] = List(a, a, a, a, b, b, b, c, c, c, c, a)
  CollectionUtils.pack(letters)                   //> res5: List[List[String]] = List(List(a, a, a, a), List(b, b, b), List(c, c, 
                                                  //| c, c), List(a))

  CollectionUtils.encode(letters)                 //> res6: List[(String, Int)] = List((a,4), (b,3), (c,4), (a,1))
  
  val s = "FRIENDS"                               //> s  : String = FRIENDS
  s flatMap { c => c+"." }                        //> res7: String = F.R.I.E.N.D.S.

}