package ch04


fun main() {
    var sum = 0;

    println("-----------------")
    for(x in 1..10) sum += x
    println("sum: $sum")

    println("-----------------")
    for(x in 5 downTo 1) println(x)

    println("-----------------")
    for(x in 1 .. 5 step 2) println(x)

    println("-----------------")
    for(x in 5 downTo 1 step 2) println(x)
}