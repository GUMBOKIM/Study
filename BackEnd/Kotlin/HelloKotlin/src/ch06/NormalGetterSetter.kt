package ch06

class User2(var _id: Int, var _name: String, var _age: Int){
    val id: Int = _id // 불변
    get() = field
    var name: String = _name
    get() = field
    set(value){
        field = value
    }
    var age: Int = _age
    get() = field
    set(value){
        field = value
    }
}

fun main() {
    val user = User2(1, "sean", 30)
    val name = user.name
    user.age = 31
//    user1.id = 11
    println("${user.id}, $name, ${user.age}")
}