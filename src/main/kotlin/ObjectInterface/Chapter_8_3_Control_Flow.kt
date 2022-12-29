package main.kotlin.ObjectInterface

import ObjectInterface.Person

class Chapter_8_3_Control_Flow {
}
// return from an enclosing function
fun lookupAlice(folks: List<Person>) {
    folks.forEach {
        if (it.name == "Alice") {
            println("found alice")
            return
        }
    }
    println("Alice not found")
}
//return from the lambada, use the function name as a return label
fun lookupAliceAndBeyond(folks: List<Person>) {
    folks.forEach {
        if (it.name == "Alice") {
            println("found alice")
            return@forEach
        }
    }
    println("end of found, this is executed")
}

// customized label. To label a lambda expreission, put the label name, followed by the @ before the opening curly brace of the lambda
fun lookupAliceAndBeyondWithLael(folks: List<Person>) {
    folks.forEach mylabel@{
        if (it.name == "Alice") {
            println("found alice")
            return@mylabel
        }
    }
    println("end of found, this is executed")
}
fun main() {
    val folks = listOf(Person("Tome", 21), Person("Alice", 23))
    lookupAlice(folks)
    println("seperator")
    lookupAliceAndBeyond(folks)
    println("seperator2")
    lookupAliceAndBeyondWithLael(folks)

}