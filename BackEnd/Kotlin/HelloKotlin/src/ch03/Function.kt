package ch03

fun sum1(a:Int, b: Int): Int {
    var sum = a + b
    return sum
}

fun sum2(a: Int, b: Int): Int {
    return a + b
}

fun sum3(a:Int, b: Int): Int = a + b

fun sum4(a:Int, b: Int) = a + b

fun max(a: Int, b: Int) = if(a > b) a else if(a < b) b else -1

fun returnUnit1(a: Int, b: Int): Unit {
    println("unit print")
}

fun returnUnit2(a: Int, b: Int) {
    println("unit print")
}


fun main() {
    println("result = ${sum1(2, 3)}")
    println("result = ${sum2(3, 4)}")

    println("result = ${max(2, 3)}")
    println("result = ${max(2, 2)}")

    returnUnit1(1,2)
    returnUnit2(1,2)



}