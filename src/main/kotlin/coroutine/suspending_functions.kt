package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

fun main(args: Array<String>) {

    GlobalScope.async {
        println(workload(3))
    }
}

suspend fun workload(n: Int) : Int {
    delay(1000)
    return n
}

//  The biggest merit of coroutines is that they can suspend without blocking a thread.
// コルーチンの最大のメリットはスレッドをブロックしないで中断することができること。
// これを可能にするために、コンパイラはある特別なコードを発火しなければなりません。
// ですので、コードに明示的に中断するかもしれないということを伝える印を、関数につける必要があります。
// その印がsuspend識別子です。

