
import scala.io.StdIn
import java.time.format.DateTimeFormatter
import org.datetime.TimePrinter

object TimeApp{

    def play() : Unit = {
        val timezone = StdIn.readLine("Give me timezone: ")
        val timePrinter = TimePrinter(DateTimeFormatter.RFC_1123_DATE_TIME)
        println(timePrinter.now(timezone))
    }
}