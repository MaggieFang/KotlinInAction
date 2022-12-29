package main.kotlin.ObjectInterface

import ObjectInterface.Person
import java.sql.Timestamp
import java.util.function.BiPredicate

class Chapter8_1_Highorder_function_declaration {
}

/**
 * higher-order function is a function that takes another function as a argument or returns ones
 * To Declare a function type, put the parameter types in parenthese, follow by a arrow and the return type e.g
 * val sum: (Int, Int) -> Int     = {x,y -> x +y}
 * val action : () -> Unit        = {println("Hello")}
 * var canReturnNull : (Int,Int) -> Int? = { null}
 * var funOrNull : ((Int, Int) -> Int?)? = null
 */
fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("result is $result")
}

//lambada as a function parameter
fun <T> Collection<T>.joinToString(
    separator: String = "",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = { it.toString() }
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(transform(element)) // same as result.append(transform.invoke(element))
    }
    result.append(postfix)
    return result.toString()
}


data class Person8(val firstName: String, val lastName: String, val phoneNumber: String?)
class ContactListFilter {
    var prefix: String = "",
    var onlyWithPhoneNumber: Boolean = false

    //lambada as a function returns
    fun getPredicate(): (Person8) -> Boolean {
        val startWithPrefit = { p: Person8 -> p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix) }
        if (onlyWithPhoneNumber) return startWithPrefit
        return { startWithPrefit(it) && it.phoneNumber != null }
    }
}

// function type helps to remove duplicate codes
enum class OS {
    android,
    ios,
    mac,
    windows
}

data class SiteVisit(val path, val duration: Double, val os: OS)

fun List<SiteVisit>.averageDuration(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()



fun main() {
    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }

    val letters = listOf("Lucy", "Lily")
    val defaultTransform = letters.joinToString(separator = "!", postfix = "!")
    val upperTransform = letters.joinToString(separator = "!", postfix = "!", transform = { it.toUpperCase() })
    println(defaultTransform)
    println(upperTransform)

}

