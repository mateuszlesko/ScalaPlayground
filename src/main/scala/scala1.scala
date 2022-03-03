/*
Traits = interfaces, share fileds between classes. Classes and objects can extends traits but traits can not be initalized so have no parameters
*/
object Scala1 {

  def play(): Unit = {
      println("Hello world!")
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
  }
}