/*
Traits = interfaces, share fileds between classes. Classes and objects can extends traits but traits can not be initalized so have no parameters
*/
object Scala1 {

  def markExam(q1 : Double, q2 : Double, q3 : Double) : Double = {
    val avgScore = (q1+q2+q3) / 3
    val scaledScore = avgScore*10/3
    Math.round(scaledScore)
  }

  def play(): Unit = {
      
      println("Hello world!")
      
      println(markExam(2.5,3.0,0.5))
      
      for (a <- "hello") println(a)
      
      val numbers = List(1,2,3,4)
      val newNumbers = numbers.map(i => i*2)
      val newNumbers2 = newNumbers.map(_*2)
      println(newNumbers2)
      val elemGt4 = newNumbers2.filter( num => num > 4)
      println(elemGt4)
      val firstGt2 = newNumbers2.find(_ >= 2) //take first element which condition is true
      println(firstGt2)
      val elemsGt3 = newNumbers2.takeWhile(_ > 3)
      println(elemsGt3)
      val newNumbers3 = newNumbers2.takeWhile(_ < 7).map(_ + 1)
      println(newNumbers3)  
      val newNumbers4 = 1 :: newNumbers3 // add 1 at begining to the list
      println(newNumbers4)  
      val newNumbers5 = newNumbers2 ::: newNumbers4 // concat 2 list, add at the end
      println(newNumbers5)

      val numberPattern = "[0-9]+".r //way:1 - create regex
      val letterPattern = scala.util.matching.Regex("[a-z]+")
      val address = "123 Washington Main Street 100"
      println(numberPattern.findFirstIn(address))
      numberPattern.findAllIn(address).foreach(number => println(number))
      println(letterPattern.findFirstIn(address))
      println(s"${numberPattern.replaceFirstIn(address,"4")}")

      val addressPattern = "([A-Za-z]+) ([0-9]+)".r
      val addressPattern(street, number) = "Beniowskiego 4"
      println(s"$street - $number") 
  }
}