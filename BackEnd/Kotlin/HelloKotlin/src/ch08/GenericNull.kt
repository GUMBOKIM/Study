//class GenericNull<T> {
class GenericNull<T : Any> {
    fun EqualityFunc(arg1: T, arg2: T) {
        println(arg1?.equals(arg2))
    }
}

fun main() {
    val obj = GenericNull<String>()
    obj.EqualityFunc("Hello", "World")

//    val obj2 = GenericNull<Int?>()
//    obj2.EqualityFunc(null, 10)
    val obj2 = GenericNull<Int>()
    obj2.EqualityFunc(10,10)
}