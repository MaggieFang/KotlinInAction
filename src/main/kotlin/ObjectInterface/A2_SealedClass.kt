package ObjectInterface

/**
 * 1. sealed restrict the subclass need to be nested class in the base class.
 * 2. If you handle all subclasses of a sealed class in a when expression, you don’t need to
provide the default branch.
 * **/

// an example of sealed classes
sealed class Expr { // mark a base class as sealed
    // list all possible subclasses as nested class
    class Num(val value: Int) : Expr()
    class Sum(val left: Int, val right: Int) : Expr()
}

fun eval(e: Expr): Int = when (e) {
    is Expr.Num -> e.value
    is Expr.Sum -> e.left + e.right
    //without seal, you need to provide a else branch to specify what should happend if none of the other branches match
}

// an example of interface implemetaion
/*
interface  Expr
class Num(val value: Int): Expr
class Sum(val left: Int, val right: Int): Expr

fun eval(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> e.left + e.right
    else -> throw IllegalArgumentException("unknow expression")
    //without seal, you need to provide a else branch to specify what should happend if none of the other branches match
}*/
