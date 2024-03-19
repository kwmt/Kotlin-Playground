package coroutine.exceptions_handling

import kotlinx.coroutines.*
import java.io.IOException

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
   val handler = CoroutineExceptionHandler { _, exception ->
       println("CoroutineExceptionHandler got $exception")
   }
    val job = GlobalScope.launch(handler) {
        val innerJob = launch {
            println("inner coroutine")
            launch {
                println("child of inner coroutine")
                launch {
                    println("child of child of inner coroutine")
                    throw IOException()
                }
            }
        }
        try {
            innerJob.join()
        } catch (e: CancellationException) {
            println("Rethrowing CancellationException with original cause")
            throw e
        }
    }
    job.join()
}