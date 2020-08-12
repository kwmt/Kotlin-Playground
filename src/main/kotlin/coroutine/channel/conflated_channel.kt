package coroutine.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
send 0
send 1
send 2
send done
receive 2
receive done
 */
fun main () {
    // チャンネルの要素は、最後の要素に置き換えられます。
    // つまり、channel.send() が中断されることはなく、channel.receive() は常に最後の要素を取得します。
    val channel = Channel<Int>(Channel.CONFLATED)
    runBlocking {

        launch {
            repeat(3) {
                println("send $it")
                channel.send(it)
            }
            println("send done")
        }

        launch {
            println("receive ${channel.receive()}")
            println("receive done")
        }
    }
}