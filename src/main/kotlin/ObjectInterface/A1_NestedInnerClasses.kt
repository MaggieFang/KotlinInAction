package ObjectInterface

import java.io.Serializable

/**
 * 1. Nested class is a static class, it doesn't referece its outer class. Innner class referce its outer class
 * **/
interface State : Serializable
interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class ButtonView : View {
    override fun getCurrentState(): State  =ButtonState()
    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    class ButtonState : State {}
}


class OuterClass{
    inner class InnerClass{
        fun getOuterReference(): OuterClass = this@OuterClass
    }
}

