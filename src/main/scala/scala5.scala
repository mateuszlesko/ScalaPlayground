import scala.io.Source
import java.io.PrintWriter


object Scala5
{
    def readFromFile(file:String) = Source.fromFile(file).getLines().mkString("\n")    
    
    def writeToFile(message:String, file:String) = new PrintWriter(file){write(message); close} 
    
    def play() : Unit = {
        writeToFile("Hola","src/main/static/file.txt")
        println(readFromFile("src/main/static/file.txt"))
        
    }
}