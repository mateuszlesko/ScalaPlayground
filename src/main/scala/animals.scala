import scala.collection.mutable.ArrayBuffer

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

    def play(): Unit = {
        val doggy = new Dog("Rex", Monday)
        val kitty = new Cat("Emma", Thursday)
        val homePets = ArrayBuffer.empty[Animal]
        homePets.append(doggy)
        homePets.append(kitty)
        homePets.foreach( pet => {
            pet.speak()
            pet.shower(Thursday)
        })
    }
}