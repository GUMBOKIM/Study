package ch04


fun main() {

    val a = 12
    val b = 7


    val max1: Int
    if (a > b)
        max1 = a
    else max1 = b

    val max2: Int
    max2 = if (a > b) a else b


    val max3 = if (a > b) {
        println("a 선택")
        a
    } else {
        println("b 선택")
        b
    }

    println(max3)

}