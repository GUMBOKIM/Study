package ch04


fun main(){
    val score = 80
    var grade: Char = 'F'

    when(score) {
        in 90 .. 100 -> grade = 'A'
        in 80 .. 89 -> grade = 'B'
        in 70 .. 79 -> grade = 'C'
    }
    println(grade)

    when {
        score in 90 .. 100 -> grade = '1'
        score in 80 .. 89 -> grade = '2'
        score in 70 .. 79 -> grade = '3'
    }
    println(grade)

}