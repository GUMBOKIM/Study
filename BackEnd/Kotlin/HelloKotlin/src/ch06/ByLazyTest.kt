class LazyTest {

    init {
        println("init block")
    }

    val subject by lazy {
        println("lazy initialized")
        "Kotlin Programming"
    }

    fun flow() {
        println("not initialized")
        println("subject one: $subject")
        println("subject tow: $subject")
    }

}

fun main() {
    val test = LazyTest()
    test.flow()
}