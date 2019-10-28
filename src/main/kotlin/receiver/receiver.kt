package receiver


fun main() {

    val sample = Sample()
    sample.receiverLambda

    val sum = fun Int.(other: Int): Int = this + other

    println(1.sum(3))

    html {       // レシーバ付きラムダがここから始まる
        body()   // レシーバオブジェクトのメソッドを呼んでいる
    }

}

class Sample {
    val lambda: (String) -> Unit = {
        print(this.javaClass.simpleName) //Sample
        println(it) //test
    }

    val receiverLambda: String.() -> Unit = {
        println(this.javaClass.simpleName) //String
        println(this) //test
    }




}

class HTML {
    fun body() {
        println("hello")
    }
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()  // レシーバオブジェクトを生成
    html.init()        // そのレシーバオブジェクトをラムダに渡す
    return html
}


