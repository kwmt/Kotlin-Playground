package delegation

fun main() {
    val view: Showable = View()
    val customView: Showable = CustomView()
    Screen(view).show()
    Screen(customView).show()
}

open class View : Showable {
    override fun show() {
        println("View.show()")
    }
}

class CustomView : View() {
    override fun show() {
        println("CustomView.show()")
    }
}

class Screen(private val showable: Showable) : Showable {
    override fun show() {
        showable.show()
    }
}

interface Showable {
    fun show()
}