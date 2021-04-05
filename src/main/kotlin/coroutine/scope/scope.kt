package coroutine.scope

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    var job: Job? = null
    try {
        if(job == null || job.isCancelled) {
            job = launch {
                while (true) {
                    delay(200)
                    println("My context is $coroutineContext")
//                    println("A context with name: ${coroutineContext + CoroutineName("test")}")
//                    println("My job is: ${coroutineContext[Job]}")
                    job?.cancel()
                }
            }
        }

        launch {
            delay(1000)
            println("cancel")
            job.cancel()
        }

        println("job: $job")
    }catch (e: CancellationException) {
        println(e)
    }


}
