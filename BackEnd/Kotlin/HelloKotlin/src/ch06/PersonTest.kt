package ch06

class User(var id: Int, var name: String, var age: Int)

fun main() {
    val user = User(1, "sean", 30)
    println("${user.id}, ${user.name}, ${user.age}")
}