package ObjectInterface

class A5_collectionFunctions {
}

fun main() {
    //flatMap do 2 things: first transform(map) each element to a collection according to the function given. and then it combines (flatten) several lists into one
    //for the example below, it first map into list of [a,b,c] and list of [d,e,f,c], and flatten the two lists into one
    val strings = listOf("abc", "defc")
    val r = strings.flatMap { it ->  it.toList() }
    println(r)


}