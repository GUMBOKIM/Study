class Outer {
    val ov = 5
    class Nested {
        val nv = 10
        fun greeting() = "[Nested] Hello ! $nv"
        fun accessOuter() {
            println(country)
            getSomething()
        }
    }

    fun outside() {
        val msg = Nested().greeting()
        println("[Outer] : $msg, ${Nested().nv}")
    }

    companion object {
        const val country = "Korea"
        fun getSomething() = println("Get somthing")
    }

}

fun main() {
    val output = Outer.Nested().greeting()
    println("output = ${output}")

    val outer = Outer()
    outer.outside()

    Outer.Nested().accessOuter()
}