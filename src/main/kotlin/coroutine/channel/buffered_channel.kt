package coroutine.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    val channel = Channel<Int>(2)
    runBlocking {
        launch {
            repeat(5) {
                println("send $it")
                channel.send(it)
            }
            println("send done")
        }

        launch {
            repeat(5) {
                println("receive ${channel.receive()}")
            }
            println("receive done")
        }
    }
}