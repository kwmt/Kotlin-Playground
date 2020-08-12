package coroutine.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
/*
send 0 and suspend
invoke receive()
get: 0 immediately
invoke receive() and suspend
send 1 and meet a receive() immediately
sender done
get: 1
receiver done
*/
fun main() {
    val channel = Channel<Int>(Channel.RENDEZVOUS)
    runBlocking {
        launch {
            println("send 0 and suspend")
            channel.send(0)
            println("send 1 and meet a receive() immediately")
            channel.send(1)
            println("sender done")
        }

        launch {
            println("invoke receive()")
            val receive0 = channel.receive()
            println("get: $receive0 immediately")
            println("invoke receive() and suspend")
            val receive1 = channel.receive()
            println("get: $receive1")
            println("receiver done")
        }
    }

}