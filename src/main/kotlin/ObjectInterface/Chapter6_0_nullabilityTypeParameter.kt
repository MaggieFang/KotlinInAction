package ObjectInterface

class Chapter6_0_nullabilityTypeParameter {
}

// all type parameter are nullable, Any?
fun <T> printHashCode(t: T) {
    println(t?.hashCode())
}

fun <T : Any> printHasCodeNotNull(t: T) {
    println(t.hashCode())
}