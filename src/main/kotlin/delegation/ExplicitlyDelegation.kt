package delegation

fun main() {
    val view = View()
    val screen = Screen(view)
    screen.show()
}

class View {
    fun show() {
        println("View.show()")
    }
}

class Screen(private val view: View) {
    fun show() {
        view.show()
    }
}