package ch06

class User4(var _id: Int, var _name: String, var _age: Int) {
    val id: Int = _id // 불변
    private var tempName: String? = null
    var name: String = _name
        get() {
            if(tempName == null) tempName = "NONAME"
            return tempName ?: throw AssertionError("Asserted by others")
        }
    var age: Int = _age
}

fun main() {
    val user = User4(1, "sean", 30)
    user.name = ""
    println("${user.name}")
}