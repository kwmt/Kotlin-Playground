package coroutine.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val channel = Channel<Int>()

        launch {
            channel.send(0)
            channel.close()
        }

        launch {
            println("receive: ${channel.receive()}")
        }
    }

}