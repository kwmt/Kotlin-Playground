package date

import org.intellij.lang.annotations.Language
import java.util.*

fun main() {
    val sample = LocaleSample()

    sample.test()
}

class LocaleSample {

    fun test() {
        val local = Locale("zh_CN")
        println(local)
        println(local.country)
        println(local.displayCountry)
        println(local.displayLanguage)
        println(local.displayName)
        println(local.variant)
        Locale.CHINESE

        "zh_CN".split("_", "-").firstOrNull()
    }
}

fun String.getLanguageCode(): String = this.split("_", "-").firstOrNull() ?: ""