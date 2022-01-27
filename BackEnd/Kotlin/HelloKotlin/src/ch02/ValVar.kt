package ch02


fun main() {
    val number = 10
    val language = "Korean"


    println("number = ${number}")
    println("language = ${language}")

//    val인 경우 재할당 불가
//    number = 20
//    language = "English"

    var numberChangeAble = 10
    println("number = ${numberChangeAble}")
    numberChangeAble = 20
    println("number = ${numberChangeAble}")

// var인 경우 재할당 가능

    var str1: String = "Hello"
    val str2 = "Hello"
    println("str1 === str2 = ${str1 === str2}")

}