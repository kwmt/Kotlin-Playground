package date

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

fun main() {
    val date = LocalDate.parse("2019-08-01")
    println(date)

    val d = Date()

    val zoneId = ZoneId.systemDefault()
    val localDate = d.toInstant().atZone(zoneId).toLocalDate()
    println(localDate)

    utc()

}

fun utc() {
    val dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    val utc = "2019-01-01T00:00:00.000Z"

    val parsed = LocalDateTime.parse(utc, dateTimeFormat)
    println(parsed)
}