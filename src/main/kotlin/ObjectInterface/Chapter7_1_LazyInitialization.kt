package ObjectInterface

class Chapter7_1_LazyInitialization {
}

/**
 * lazy initialization is a common pattern that entails creating part of an object on demand, when it's accessed for the first time
 * use case: there is a class called Person that lets you access a list of the emails written by him.
 * The emails stored in a database that takes long to access. we want to load it only when needs it and only load it once
 */
fun loadEmail(author: Author): List<String> {
    println("loading emails from db for $author")
    return listOf("a", "b")
}

open class Author(val name: String)

// implement lazy initialization using a backing property. not thread-safe
class AuthorBackingProperty(name: String) : Author(name) {
    private var _emails: List<String>? = null
    val emails: List<String>
        get() {
            if (_emails == null) {
                loadEmail(this)
            }
            return _emails!!
        }
}

// implement lazy initialization using a delegated property
// the by keyword associated a property with a delegate object
class AuthorDelegated(name: String) : Author(name) {
    val emails by lazy { loadEmail(this) }
}


