import java.util.*

fun main() {
    val arr = arrayOf(8, 4, 3, 2, 5, 9, 1)
    println("arr = ${Arrays.toString(arr)}")

    val sortedNums = arr.sortedArray()
    println("sortedNums = ${Arrays.toString(sortedNums)}")

    val sortedNumsDesc = arr.sortedArrayDescending()
    println("sortedNumsDesc = ${Arrays.toString(sortedNumsDesc)}")

    arr.sort(1, 3)
    println("arr = ${Arrays.toString(arr)}")

    arr.sortDescending()
    println("arr = ${Arrays.toString(arr)}")

    val listSorted = arr.sorted()
    val listSortedDesc = arr.sortedDescending()
    println("listSorted = ${listSorted}")
    println("listSortedDesc = ${listSortedDesc}")

    val items = arrayOf<String>("Dog", "Cat", "Lion", "Kangaroo", "Po")
    items.sortBy{item -> item.length}
    println(Arrays.toString(items))

}