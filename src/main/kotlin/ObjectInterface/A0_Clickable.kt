package ObjectInterface
/**
 * 1.class, interface, abstract class
 * 2. access modifier: open, final
 * 3. visibility modifer: public(default), internal, protected, private
 * **/
interface Clickable {
    fun click()
    fun showOff() = println("click show off")
}

interface Focusable {
    fun setFocus(focus: Boolean)
    fun showOff() = println("focusable show off")
}

class Button : Clickable, Focusable {
    override fun click() {
        println("button is click")
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    override fun setFocus(focus: Boolean) {
        println("button focus = ${focus}")
    }
}

open class RichButton : Clickable {
    override fun click() {
        println("override method is open")
    }

    final override fun showOff() {
        super.showOff()
        println("add final on the open method to make it final, cannot be rewrite")
    }
}

class SubRichButton : RichButton() {
    override fun click() {
        println("override an open class")
        println("a class is default to final, cannot be ")
    }
}

fun main() {
    println("test interface ******")
    val btn = Button()
    btn.showOff()
    btn.setFocus(false)
    println("test class open and final ******")
    val subBtn = SubRichButton()
    subBtn.click()
    subBtn.showOff()

}