//a class can have one constructor, and you can use it by using the keyword new.
class Person(val name:String, val sex:Char)

object Person{
    //method apply is the way to create an instance of class in diffrent way
    def apply(p1:Person, p2:Person) : Person = new Person(s"Daughter of ${p1.name} and ${p2.name}",'W')
    def apply(name:String) : Person = if(name.takeRight(1) == "a") new Person(name,'W') else new Person("no name",'M')
    def play() : Unit = {
        val person1 : Person = new Person("Anna",'W')
        val person2 : Person = new Person("Adam",'M')
        val person3 : Person = Person.apply(person1,person2)
        val person4 : Person = Person.apply("Anna")
        println(person3.name)
        println(person4.sex)
    }
}