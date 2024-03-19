package coroutine.exceptions_handling

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
    var job: Job? = null
    try {
        job = GlobalScope.launch {// root coroutine with launch
            println("Throwing exception from launch")
            throw IndexOutOfBoundsException()  // Will be printed to the console by Thread.defaultUncaughtExceptionHandler
        }
    } catch (e: IndexOutOfBoundsException) {
        println("Caught IndexOutOfBoundsException")
    }
    job?.join()
    println("Joined failed job")
    val deferred = GlobalScope.async {
        println("Throwing exception from async")
        throw ArithmeticException()
    }
    try {
        deferred.await()
        println("Unreached")
    } catch (e: ArithmeticException) {
        println("Caught ArithmeticException")
    }
}