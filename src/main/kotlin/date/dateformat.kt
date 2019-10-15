package date

import java.text.SimpleDateFormat
import java.util.*
import javax.swing.text.View

fun main() {

/*
    val yyyyMMddHHmmss = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPAN)
    val date = yyyyMMddHHmmss.parse("2019-08-19 10:50:00")
    print(date.toString())
*/

    val value: String? = null

    val text = value?.let { "$it android" }

    println(text)

    println(ViewType.A.ordinal)
    println(ViewType.B.ordinal)

    val vt = ViewType.typeOf(5)
    val ret = when (vt) {
        ViewType.A -> "A"
        ViewType.B -> "B"
        ViewType.C -> "C"
    }
    println(ret)



}


enum class ViewType {
    A, B, C;

    companion object {
        fun typeOf(position: Int): ViewType {
            return values().firstOrNull { it.ordinal == position } ?: C
        }
    }
}

