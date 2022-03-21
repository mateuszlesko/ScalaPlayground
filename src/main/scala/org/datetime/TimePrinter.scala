package org.datetime

import java.time.format.DateTimeFormatter
import java.time.{ZoneId, ZonedDateTime}

class TimePrinter(formatter:DateTimeFormatter){
    
    private def dateTime2Str(dateTime: ZonedDateTime) : String = {
        formatter.format(dateTime)
    }

    private def currentDateTime(timezone:String) : ZonedDateTime = {
        val zoneId = ZoneId.of(timezone)
        ZonedDateTime.now(zoneId)
    }

    def now(timezone:String) : String = {
        val timezoneCorrect = timezone.split("/").map(_.toLowerCase()).map(_.capitalize).mkString("/")
        val dateTime = currentDateTime(timezoneCorrect)
        dateTime2Str(dateTime)
    }

}