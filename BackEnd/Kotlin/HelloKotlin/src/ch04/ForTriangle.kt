package ch04


fun main() {
    val n = 5

    for (line in 1..n){
        for (space in 1..(n - line)) print(" ")
        for (star in 1..(2*line - 1)) print("*")
        println()
    }
}