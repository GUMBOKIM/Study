package ch06

open class First {
    open val x: Int = 0
        get() {
            println("First X")
            return field
        }
    val y: Int = 0
}

class Second : First() {
    override val x: Int = 0
        get() {
            println("Second X")
            return field + 3
        }
}

fun main() {
    val second = Second()
    println(second.x)
}