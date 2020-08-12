package coroutine.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    val channel = Channel<Int>(Channel.UNLIMITED)
    runBlocking {

        launch {
            repeat(100) {
                println("send $it")
                channel.send(it)
            }
            println("send done")
        }

        launch {
            repeat(100) {
                println("receive ${channel.receive()}")
            }
            println("receive done")
        }
    }
}