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
    
    class Dog (val name:String = "Unknown", var showerDay : DayOfWeek) extends Animal with HasTail{
        
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
        case "1" => Monday
        case "2"=> Tuesday
        case "3" => Wednesday //unfortently polish keys are not supported
        case "4" => Thursday
        case "5" => Friday
        case "6" => Saturday
        case "7" => Sunday
        case _ => throw new RuntimeException("no recognised")
    }

    def play(): Unit = {
        val doggy = new Dog("Rex", Monday)
        val kitty = new Cat("Emma", Thursday)
        val homePets = ArrayBuffer.empty[Animal]
        homePets.append(doggy)
        homePets.append(kitty)

        val todayDate:Date = Date()
        val todayDayNumber:String =SimpleDateFormat("u").format(todayDate) //u give number of day

        homePets.foreach( pet => {
            pet.speak()
            pet.shower(getDayAsEnum(todayDayNumber))
        })
    }
}