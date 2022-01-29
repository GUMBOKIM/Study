package ch04


fun main() {

    val score = 80

    var grade: Char = 'F'

    if (score >= 90){
        grade = 'A'
    } else if (score >= 80 && score < 90) {
        grade = 'B'
    } else if(score >= 70 && score < 80){
        grade = 'C'
    }

    println(grade)

    if (score >= 90){
        grade = '1'
    } else if (score in 80..89) {
        grade = '2'
    } else if(score in 70..79){
        grade = '3'
    }

    println(grade)


}