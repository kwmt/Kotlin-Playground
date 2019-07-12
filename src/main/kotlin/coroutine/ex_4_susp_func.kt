package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    val job = launch {
        doWorld()
    }
    println("Hello,")
    job.join()
}

// suspendはcoroutine内で使われる
private suspend fun doWorld() {
    delay(1000L)
    println("World!")
}