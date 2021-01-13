package order

fun main() {

    var i: Int = 16 // nは入力サイズとする

    var count = 0
    while (i > 0) {
        i /= 2
        count++ // logn回実行
    }
    println(count)
}