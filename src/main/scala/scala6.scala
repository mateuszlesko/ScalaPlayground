
enum Currency(val symbol:String){
    case Dollar extends Currency("$")
    case Euro extends Currency("€")
    case Zloty extends Currency("pln") 
    case Koruna extends Currency("Kč")
}

object Scala6{
    var exchangeRate = collection.mutable.Map[Currency, Double](Currency.Dollar -> 3.75, Currency.Euro -> 4.1, Currency.Koruna->1.2)
    
    def play() : Unit ={
        val d  = Currency.Dollar //sign to const enum case Dollar
        val pln = Currency.fromOrdinal(2) //get 3rd element from enum
        println(pln.symbol)
        val currencies : Array[Currency] = Currency.values //get values from enum
        currencies.foreach(x => println(s"${x} - ${x.symbol}"))
        exchangeRate.foreach(x => println(s"${x._1} ${x._2} pln"))
    }
}