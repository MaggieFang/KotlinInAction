package ObjectInterface

/***
 * two kinds of properties: 1) backing field: properties that store values when class initialization 2) and properties with custom accessors that calculate values on every access.
 *
 */


class User(val name: String){
    var address : String = "unknow"
        set(newAddress: String) {
            println("the address for $name is changed from $field to $newAddress")
            field = newAddress
        }
}

fun main() {
    val maggie = User("Maggie")
    maggie.address = "130 key"
    println(maggie.address)
}