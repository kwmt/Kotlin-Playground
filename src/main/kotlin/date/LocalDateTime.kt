package date

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

fun main() {
    val date = LocalDate.parse("2019-08-01")
    println(date)

    val d = Date()

    val zoneId = ZoneId.systemDefault()
    val localDate = d.toInstant().atZone(zoneId).toLocalDate()
    println(localDate)


}