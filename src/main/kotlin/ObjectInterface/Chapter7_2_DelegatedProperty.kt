package ObjectInterface

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import java.lang.reflect.Type
import kotlin.reflect.KProperty

class Chapter7_2_DelegatedProperty {
}

/**Basic format
 * class Foo{
var P: Type  by Delegate()
}
 * the type of P delegate the logic of its accssors to another object: in this class, a new instance of Delegate class
 **/


class PersonForDelegate(val name: String,  age: Int, salary: Int):PropertyChangeSupportAware(){
    var age : Int by ObservableProperty(age, changeSupport)
    var salary: Int by ObservableProperty(salary, changeSupport)
}


open class PropertyChangeSupportAware {
    protected val changeSupport = PropertyChangeSupport(this)
    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }

}

class ObservableProperty(var propvalue: Int, val changeSupport: PropertyChangeSupport) {
    operator fun getValue(p: PersonForDelegate, prop: KProperty<*>): Int = propvalue
    operator fun setValue(p: PersonForDelegate, prop: KProperty<*>, newValue: Int) {
        val oldValue = propvalue
        propvalue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}