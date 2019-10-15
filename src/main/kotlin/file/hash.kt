package file

import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {
//    val f = File.createTempFile()
//    val uri = URI.create("file:///temp/text.txt")
////    println(uri.scheme)
////
////    val time = System.currentTimeMillis()
////
////    println(Date().formatDate())
////    println(Date().formatDate())
//
////    val mark = MarkPattern(listOf(3, 4, 6, 8))
//    val mark = MarkPattern(listOf(9, 8, 3, 7))
////    val mark = MarkPattern(listOf(1, 2, 3, 4))
//    println(mark.challenges)
    println(Paths.get("src/main/kotlin/file").toAbsolutePath().toString())

    val stringBuilder = StringBuilder()

    File("${Paths.get("src/main/kotlin/file").toAbsolutePath().toString()}/test.txt").bufferedReader().use {
        var line = it.readLine()
        while (line != null) {
            stringBuilder.append(line).append("\n")
            line = it.readLine()
        }
    }
    println(stringBuilder.toString())

}


data class MarkPattern(
    private val marks: List<Int>
) {
    val challenges: List<Int>

    init {
        // 例えば
        // 9, 8, 3, 7
        // から
        // 0, 0, 3, 0, 0, 0, 4, 2, 1
        // を生成する
        val temp = (0 until 9).map { 0 }.toMutableList()
        marks.forEachIndexed { index, i ->
            temp[i - 1] = index + 1
        }
        challenges = temp
    }
}

fun Date.formatDate(year: Boolean = true, month: Boolean = true, day: Boolean = true): String {
    var pattern = ""
    if (year) {
        pattern += "yyyy年"
    }
    if (month) {
        pattern += "MM月"
    }
    if (day) {
        pattern += "dd日"
    }
    return if (pattern.isNotEmpty()) SimpleDateFormat(pattern).format(this) else ""
}