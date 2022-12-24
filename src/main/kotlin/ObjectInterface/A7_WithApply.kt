package ObjectInterface

class A7_WithApply {
}

// with is to perform multiple operations on the same objects without repeating its name
// apply is similar to with, but apply always return the receiver object

// example navie without `with`, repeating `result` many times
fun alphabet() : String {
    val result = java.lang.StringBuilder()
    for( letter in 'A'.. 'Z'){
        result.append(letter)
    }
    result.append("\n now I know he alphabet")
    return result.toString()
}

fun alphabetWith() = with(java.lang.StringBuilder()){
    for (letter in 'A'.. 'Z'){
        append(letter)
    }
    append("\n now I know he alphabet")
    toString()
}

fun alphabetApply() = StringBuilder().apply {
    for (letter in 'A'.. 'Z'){
        append(letter)
    }
    append("\n now I know he alphabet")

}.toString()



fun main() {
}