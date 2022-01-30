package ch06

class User3(var _id: Int, var _name: String, var _age: Int) {
    val id: Int = _id // 불변
    var name: String = _name
        set(value) {
            println("The name was changed")
            field = value
        }
    var age: Int = _age
}

fun main() {
    val user = User3(1, "sean", 30)
    user.name = "kim"
    user.age = 31
    println("${user.id}, ${user.name}, ${user.age}")
}