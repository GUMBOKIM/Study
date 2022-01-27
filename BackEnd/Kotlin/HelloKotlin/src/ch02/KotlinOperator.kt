package ch02


fun main() {
    val num01 = 127
    println(num01.javaClass)

    val num02 = 127123123123123132
    println(num02.javaClass)

    // 자료형을 지정해주지 않으면 알아서 들어감

    val a: Int = 128
    val b: Int = 128
    println(a == b)
    println(a === b)

    val c: Int = 128
    val d: Int? = 128
    println(c == d)
    println(c === d)



}