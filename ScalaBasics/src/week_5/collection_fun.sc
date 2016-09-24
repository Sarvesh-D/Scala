package week_5

object collection_fun {

  val n = 9                                       //> n  : Int = 9
  (1 until n) flatMap (x => (1 until x) map (y => (x, y))) filter (pair => NumberUtils.isPrime(pair._1 + pair._2))
                                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5), (7,4), (7,6), (8,3), (8,5))

  for {
    i <- 1 until n
    j <- 1 until i
    if NumberUtils.isPrime(i + j)
  } yield (i, j)                                  //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5), (7,4), (7,6), (8,3), (8,5))

  lazy val names = List("Jeffrey Black", "Joseph Perez", "Joan Fernandez", "Judy Tucker", "Sandra Mendoza", "Walter Payne", "Sara Berry", "Thomas Wood", "Amanda Daniels", "Andrea Hart")
                                                  //> names: => List[String]

  val countryCodes = List("SE,Sweden", "CN,China", "ID,Indonesia", "CN,China", "CO,Colombia", "SD,Sudan", "CL,Chile", "PH,Philippines", "ID,Indonesia", "BR,Brazil")
                                                  //> countryCodes  : List[String] = List(SE,Sweden, CN,China, ID,Indonesia, CN,Ch
                                                  //| ina, CO,Colombia, SD,Sudan, CL,Chile, PH,Philippines, ID,Indonesia, BR,Brazi
                                                  //| l)

  names filter { name => name.length() < 13 }     //> res2: List[String] = List(Joseph Perez, Judy Tucker, Walter Payne, Sara Berr
                                                  //| y, Thomas Wood, Andrea Hart)

  names groupBy { name => name.head }             //> res3: scala.collection.immutable.Map[Char,List[String]] = Map(T -> List(Thom
                                                  //| as Wood), J -> List(Jeffrey Black, Joseph Perez, Joan Fernandez, Judy Tucker
                                                  //| ), A -> List(Amanda Daniels, Andrea Hart), W -> List(Walter Payne), S -> Lis
                                                  //| t(Sandra Mendoza, Sara Berry))

  names groupBy { name => name.length() }         //> res4: scala.collection.immutable.Map[Int,List[String]] = Map(10 -> List(Sara
                                                  //|  Berry), 14 -> List(Joan Fernandez, Sandra Mendoza, Amanda Daniels), 13 -> L
                                                  //| ist(Jeffrey Black), 12 -> List(Joseph Perez, Walter Payne), 11 -> List(Judy 
                                                  //| Tucker, Thomas Wood, Andrea Hart))
  lazy val codeCountryNameMap =
    {
      for {
        countryCode <- countryCodes
        code = countryCode.split(",")
      } yield code(0) -> code(1)
    }.toMap withDefaultValue("Country Not found") //> codeCountryNameMap: => scala.collection.immutable.Map[String,String]
   codeCountryNameMap.size                        //> res5: Int = 8
	
	names(1)                                  //> res6: String = Joseph Perez
	
	NumberUtils.nMultilpesOf(10, 11)          //> res7: List[Int] = List(11, 22, 33, 44, 55, 66, 77, 88, 99, 110)
	
	codeCountryNameMap                        //> res8: scala.collection.immutable.Map[String,String] = Map(ID -> Indonesia, 
                                                  //| PH -> Philippines, SD -> Sudan, CL -> Chile, SE -> Sweden, CO -> Colombia, 
                                                  //| BR -> Brazil, CN -> China)
val countryNameCodeMap =
	for ((code,name) <- codeCountryNameMap) yield name -> code
                                                  //> countryNameCodeMap  : scala.collection.immutable.Map[String,String] = Map(P
                                                  //| hilippines -> PH, China -> CN, Sweden -> SE, Brazil -> BR, Chile -> CL, Ind
                                                  //| onesia -> ID, Sudan -> SD, Colombia -> CO)

}