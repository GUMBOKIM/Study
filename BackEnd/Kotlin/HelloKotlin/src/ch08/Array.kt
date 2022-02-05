import java.util.*

fun main() {
    val numbers = arrayOf<Int>(1, 2, 3, 4, 5)
    val numbers2 = intArrayOf(1, 2, 3, 4, 5)
    for (element in numbers) println(element)
    println("-----------")
    println(Arrays.toString(numbers))
    println(numbers.get(2))
    println(numbers[2])

    println("-----------")
    val animals = arrayOf<String>("Cat", "Dog", "Lion")
    for (element in animals) println(element)

    println("-----------")
    var arr = Array(5, { i -> i * 2 })
    println(Arrays.toString(arr))
    var arr2 = arrayOfNulls<Int>(10)
    println(Arrays.toString(arr2))
    var arr3 = Array(100, {100})
    println(Arrays.toString(arr3))

    println("-----------")
    var arrOrigin = intArrayOf(1,2,3,4,5)
    println("origin = ${Arrays.toString(arrOrigin)}")
    println("arrOrigin.first() = ${arrOrigin.first()}")
    println("arrOrigin.last() = ${arrOrigin.last()}")
    println("arrOrigin.contains(6) = ${arrOrigin.contains(6)}")
    println("4 in arrOrigin = ${4 in arrOrigin}")
    var arrAfterPlus = arrOrigin.plus(6)
    println("afterPlus = ${Arrays.toString(arrAfterPlus)}")
    var arrAfterSlice = arrOrigin.sliceArray(0..2)
    println("afterSlice = ${Arrays.toString(arrAfterSlice)}")

}