//high order functions example:
import scala.collection.mutable.HashMap

object Scala2 {

    
    val raiseSalaries = (x : Double, p:Double) => x+(x*p)
    
    val cuttingSalaries = (x : Double, p: Double) => x-(x*p)
    
    var workers = HashMap[String,Double]()
    
    def addNewWorker(worker:HashMap[String,Double] ) : HashMap[String,Double] = workers ++ worker

    def play() : Unit = {
            
        val salaries = Seq(20000.0, 40000.0, 50000.0)
        val newSalaries = salaries.map( salary => raiseSalaries(salary,0.4))
        println(salaries)
        println(newSalaries)
        workers = addNewWorker(HashMap[String,Double]("Anna"->4000))
        workers = addNewWorker(HashMap[String,Double]("Jan"->3000))
        println(s"Sklad firmy : $workers")

    }
    
}