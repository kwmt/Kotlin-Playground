package coroutine.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
fun main() = runBlocking {
    val watch = WatchHoge()

    GlobalScope.launch {
        flowFrom(watch).collect {
            println("onchange: $it")
        }
    }

    watch.start()
}

/**
 * callbackからFlowに変換する例
 */
@ExperimentalCoroutinesApi
private fun flowFrom(watchHoge: WatchHoge): Flow<Int> = callbackFlow {
    val callback = object : OnChangeListener {
        override fun onChange(i: Int) {
            offer(i)
        }
    }
    watchHoge.listener = callback

    // 必ず必要
    // これがないと
    // IllegalStateException: 'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.
    // という実行時エラーになる。
    awaitClose {
        watchHoge.listener = null
    }
}

/**
 * 今回、CallbackをFlowに変更したいインターフェース
 */
interface OnChangeListener {
    fun onChange(i: Int)
}

/**
 * 変更を監視するクラス例
 * 1秒ごとにonChange(Int)をコールしている。
 *
 * 例）
 * - Wifiにつながっているか
 * - Firestoreのドキュメント変更監視
 * などのイメージ
 */
class WatchHoge() {
    var listener: OnChangeListener? = null

    fun start() = runBlocking {
        var i = 0
        while (true) {
            listener?.onChange(i)
            i++
            delay(1000)
        }
    }
}