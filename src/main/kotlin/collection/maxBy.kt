package collection

fun main() {
    val test = Test("test")
    val b = test.header
    if (!b.isNullOrEmpty()) {
        val a: String = b
    }

    print(KotlinVersion.CURRENT)

}

data class Test(private val total: String?) {
    val header: String?
        get() = total
}
