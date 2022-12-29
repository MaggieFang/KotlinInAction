package main.kotlin.ObjectInterface

class Chapter8_2_inline {
}

//https://www.geeksforgeeks.org/kotlin-inline-functions/
// reduce memory overhead which request the compplier to not allocate memory and simply copy the inlined code of that function at the calling place
//Using the inline keyworks is likely to improve performace only with functions that takes lambada as arguments.
inline fun highFunc(str: String, mycall: (String) -> Unit) {
    mycall(str)
}

// inline allow retrun from lambda expression itself and exit the function in which inlined function is called. It makes sense since the incline request copy the code at the calling place, so that return is allowed
//var lambda = { println("lambada don't allow retrun statement, so this will be compile error") return }
inline fun inlinedFunc(f1: () -> Unit, f2: () -> Unit) {
    f1()
    f2()
}

// if we want only some of the lambdas passed to an inline function to be inlined,
// we can mark some of the function parameters with the noinline modifier. this could be use the lambada contains a lot of code or it's not allowed inline
inline fun partNoInLine(f1: () -> Unit, noinline f2: () -> Unit) {
    f1()
    f2()
}
//Reified Type Parameters
inline fun <reified T> genericFunc(){
    println(T::class)
}

fun foo(i: Int): Int{
    val  a = i
    return a
}
// inline keyword copy the inline properties accessor methods to calling place so don't need a backing field
inline var flag : Boolean
    get() = foo(10)  == 10
    set(value) {value}


fun main() {
    highFunc("inline, go to tool-> kotlin-> show bytecode, and decompile", ::println)

    println("main function starts")
    inlinedFunc({
        println("f1 execute")
        return
    }, { println("f2 is not excuted because F1 returns") })
    println("main function ends")


    partNoInLine({
        println("f1 can use returns since it's inlined")
        return
    },
        {
            println("F2 not allowed to have return since it's no inline")
        })

    println(flag)
}