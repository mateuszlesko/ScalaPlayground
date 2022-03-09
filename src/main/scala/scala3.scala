//Inheritance of class
class Robot(name:String = "Unknown"){
    def welcome() : String = s"Hello I'm $name"

}
case class GermanyRobot(name:String = "Unbekannt") extends Robot(name){
    override def welcome() : String = s"Hallo Ich bin $name"
}

//use for every type that inherit from Robot
def introduceRobot[T <: Robot](robot : T) : String = robot.welcome()

object Scala3 {

    def play() : Unit = {
        val robot = new Robot("3CPO")
        val robotG = new GermanyRobot("R2-D2") 
        val robotEn : Robot = robotG.asInstanceOf[Robot]
        println(robot.welcome())
        println(robotG.welcome())
    }

}