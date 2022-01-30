package ch06

class User1(var _id: Int, var _name: String, var _age: Int){
    val id: Int = _id // 불변
    var name: String = _name
    var age: Int = _age
}

fun main() {
    val user = User1(1, "sean", 30)
    val name = user.name
    user.age = 31
//    user1.id = 11
    println("${user.id}, $name, ${user.age}")
}