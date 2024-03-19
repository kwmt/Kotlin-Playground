package coroutine.exceptions_handling

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
   val job = launch {
       val child = launch {
           try {
               println("Child is running")
               delay(Long.MAX_VALUE)
           } finally {
               println("Child is cancelled")
           }
       }
       println("${Thread.currentThread()}")
       yield()
       println("Cancelling child")
       child.cancel()
       child.join()
       yield()
       println("Parent is not cancelled")
   }
    println("${Thread.currentThread()}")
    job.join()
}