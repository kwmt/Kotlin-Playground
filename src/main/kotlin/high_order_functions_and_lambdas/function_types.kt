package high_order_functions_and_lambdas


/**
 * すべての関数型はカッコで囲まれたパラメータタイプリストと戻り値があります。
 * 例: (A,B) -> C
 * パラメータタイプリストが空の場合
 * () -> A
 * となります。
 *
 * オプションとして receiver型があります。
 * 例: A.(B) -> C
 * これは、Aオブジェクトでコールされる関数で引数Bをとり、Cを返します。
 *
 * 関数パラメータにオプションとして名前をつけることができます。
 * 例: (x: Int, y: Int) -> Point
 * これらの名前は、パラメータの意味をドキュメント化するために使用することができます。
 *
 * ## 関数型のインスタンス化
 * 関数リテラルの中でコードブロックを使用します。
 * - ラムダ式： { a, b -> a + b }
 * - 匿名関数： fun(s: String): Int { return s.toIntOrNull() ?: 0 }
 */
fun main() {
    koinModuleWrapper {
        println("test")
    }
}

class Module ()

data class KoinModuleWrapper(val module: Module) {

}

fun koinModuleWrapper(wrapper: KoinModuleWrapper.() -> Unit) {
    val koinModuleWrapper = KoinModuleWrapper(Module())
    koinModuleWrapper.wrapper()
}


