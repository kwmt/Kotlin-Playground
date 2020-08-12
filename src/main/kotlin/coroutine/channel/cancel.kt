package coroutine.channel

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ClosedReceiveChannelException
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val channel = Channel<Int>()

        launch {
            channel.cancel()
        }

        launch {
            try {
                channel.send(0)
            } catch (e: CancellationException) {
                println("throw CancellationException here")
            }
        }

        launch {
            try {
                channel.receive()
            } catch (e: ClosedReceiveChannelException) {
                println("throw ClosedReceiveChannelException() here")
            }
        }
    }
}