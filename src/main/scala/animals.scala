import scala.collection.mutable.ArrayBuffer
import java.text.SimpleDateFormat;
import java.util.Date;

object Animals {

    trait Animal{
        
        val name: String
        
        var showerDay : DayOfWeek
        
        def speak():Unit
        
        def shower(today:DayOfWeek): Unit //Unit is a type, that works like java's void
    
    }
  
    trait HasTail{
        
        def wagTail():Unit
    
    }
    
    class Dog (val name:String, var showerDay : DayOfWeek) extends Animal with HasTail{
        
        def speak() = println(s"Hau hau- $name")
        
        def shower(today:DayOfWeek) = if (today == showerDay) println("It's Doggy shower time")
        
        def wagTail() = println(" wag left, wag right")
    }

    class Cat (val name:String, var showerDay : DayOfWeek) extends Animal with HasTail{
        
        def speak() = println(s"Miau mialu - $name")
        
        def shower(today:DayOfWeek) = if (today == showerDay) println("It's Kitty shower time")
        
        def wagTail() = println("wag right, wag left")
    }

    //names of day are in polish language
    def getDayAsEnum(today:String): DayOfWeek = today match{
        case "pon." => Monday
        case "wto." => Tuesday
        case "śro." => Wednesday
        case "czw." => Thursday
        case "pią." => Friday
        case "sob." => Saturday
        case "nie." => Sunday
        case _ => throw new RuntimeException("no recognised")
    }

    def play(): Unit = {
        val doggy = new Dog("Rex", Monday)
        val kitty = new Cat("Emma", Thursday)
        val homePets = ArrayBuffer.empty[Animal]
        homePets.append(doggy)
        homePets.append(kitty)

        val todayDate:Date = Date()
        val todayName:String =SimpleDateFormat("EEE").format(todayDate) //E stands for letter in name of week

        //println(s"today is ${todayName}")

        homePets.foreach( pet => {
            pet.speak()
            pet.shower(getDayAsEnum(todayName))
        })
    }
}