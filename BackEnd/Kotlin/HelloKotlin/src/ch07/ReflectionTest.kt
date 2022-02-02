import kotlin.reflect.KClass
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties

class User1(val id: Int, val name: String, var grade: String = "Normal"){
    fun check() {
        if (grade == "Normal") println("You need to get the Silver grade")
    }
}

fun main() {
    println(User1::class)
    val classInfo = User1::class
    classInfo.memberProperties.forEach{
        println("Property name : ${it.name}, type : ${it.returnType}")
    }
    classInfo.memberFunctions.forEach {
        println("Function name : ${it.name}, type : ${it.returnType}")
    }
    getKotlinType(User1::class)
}

fun getKotlinType(obj: KClass<*>) {
    println(obj.qualifiedName)
}
