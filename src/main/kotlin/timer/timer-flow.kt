
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.time.LocalDateTime
import kotlin.time.seconds
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

val scope =  CoroutineScope(Job() + Dispatchers.Default)

fun main() {
    println("hello")

//    var job = CoroutineScope(Dispatchers.IO).launchPeriodicAsync(1_000L) {
//        //...
//        println("h")
//    }
    val flowA = flow {

        while(true) {
        delay(2000L)
        emit("a")
        }
    }


    runBlocking {
        combine(
            flowA, tickerFlow(1000L), ::Pair
        )
            .distinctUntilChanged()

            .onEach { (a,b) ->
                println("$a, $b")
            }
            .launchIn(scope) // or lifecycleScope or other

    }
    Thread.sleep(10000)

}


fun tickerFlow(period: Long, initialDelay: Duration = Duration.ZERO) = flow {
//    delay(initialDelay)
    while (currentCoroutineContext().isActive) {
        delay(period)
        emit(Unit)
    }
}.map { LocalDateTime.now() }

fun CoroutineScope.launchPeriodicAsync(
    repeatMillis: Long,
    action: () -> Unit
) = this.async {
    if (repeatMillis > 0) {
        while (isActive) {
            action()
            delay(repeatMillis)
        }
    } else {
        action()
    }
}