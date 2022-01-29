package ch04


fun main() {

    var number = 5
    var factorial: Long = 1

    while (number > 0) {
        factorial *= number
        --number
    }

    println(factorial)

    var printCnt = 5

    do {
        println(printCnt)
        printCnt--
    } while (printCnt > 0)

}