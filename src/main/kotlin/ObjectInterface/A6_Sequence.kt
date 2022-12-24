package ObjectInterface

class A6_Sequence {
}

fun main() {
    val people = listOf(Person("Lily", 31), Person("Tom", 29))
    // sequence could avoid creating intermediate objects. so as a rule, use sequence when you have a chain of operations on a large collections.
    people.asSequence()
        .map { it.name }
        .filter { it.startsWith("L") }
        .toList()

    // Two operations of sequence : intermediate operations and terminal operation.  intermediate operations returns another sequence. it's lazy. terminal returns a result
    /***
     * result
    map 1
    map 2
    map 3
    map 4
    filter 1
    filter 4
    filter 9
    filter 16

     map execute first for each element, and then filter
     */
    listOf(1, 2, 3, 4)
        .map {
            println("map $it")
            it * it
        }.filter {
            println("filter $it")
            it % 2 == 0
        }.toList()

    // print nothing since it's intermediate operations
    listOf(1, 2, 3, 4).asSequence()
        .map {
            println("map $it")
            it * it
        }.filter {
            println("filter $it")
            it % 2 == 0
        }

    /*** result
     map 1
    filter 1
    map 2
    filter 4
    map 3
    filter 9
    map 4
    filter 16

     all operations are applied to each element sequentially
     */
    listOf(1, 2, 3, 4).asSequence()
        .map {
            println("map $it")
            it * it
        }.filter {
            println("filter $it")
            it % 2 == 0
        }.toList()


}