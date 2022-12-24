package ObjectInterface

class Lambada {
}

data class Person(val name: String, val age: Int)

fun salute() = println("Salute!!!")

fun main() {
    val people = listOf(Person("Lily", 31), Person("Lucy", 29))
    // 1. it's from people.maxByOrNull ({ p: Person -> p.age }), the curly braces is a lambada expression, and you pass it as an argument of the function.
    // the lambada expression takes one argument of type Person and return its age
    // kotlin let you to move lambda out of parenthese if it's the last argument in a function call , so it could be  people.maxByOrNull() { p: Person -> p.age }
    // and if lambda is the only argument, the parenthese could be removed
    val form1 = people.maxByOrNull { p: Person -> p.age }
    // and since this maxby functin, the lambada param is always same as the collection type. sp we could omit lambada parameter type to people.maxByOrNull { p -> p.age }
    val form2 = people.maxByOrNull { it.age }

    // you could store the lambada as a variable,
    val getAge = { p: Person -> p.age }
    val form3 = people.maxByOrNull(getAge)

    val sum = { x: Int, y: Int ->
        println("multiple line of lambada example, trying to see the sum of two integer")
        x + y
    }
    println(sum(1, 3))
   // 2. member reference. it's also a lambada
   val form4 =  people.maxByOrNull(Person::age)
    // for a top level function, you could omit the class name and start with ::
    run { salute() }
    run(::salute)

    //3.  when you have several arguments, you could emphasize the lambda inside the parentheses, or you could put it out of it. If you have >=2 lambada, you couldn't move more than one out.


}

