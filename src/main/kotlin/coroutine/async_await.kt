package coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking {
    println("start")
    val text = withContext(Dispatchers.Default) {
        delay(1000)
        "coroutine!"
    }

    val text2 = withContext(Dispatchers.Default) {
        delay(500)
        "coroutine2!"
    }

    println(text)
    println(text2)
    println("end")
}