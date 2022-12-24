package ObjectInterface

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import java.lang.reflect.Type

class Chapter7_2_DelegatedProperty {
}

/**Basic format
 * class Foo{
var P: Type  by Delegate()
}
 * the type of P delegate the logic of its accssors to another object: in this class, a new instance of Delegate class
 **/

open class PropertyChangeSupportAware {
    protected val changeSupport = PropertyChangeSupport(this)
    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }

}
