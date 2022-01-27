package ch03

fun print(name: String, email: String = "default") {

}

fun printMultiParam(a: Int = 1, b: Int = 2, c: Int = 3) {
    println("$a, $b, $c")
}

fun printVarargs(vararg intArr: Int){
    for (num in intArr)
        println(num)
}

fun highFunc(sum: (Int, Int) -> Int, a: Int, b: Int) : Int = sum(a,b)

fun main() {
    print(name = "김대희")
    printMultiParam(a=2, b=222)
    printVarargs(1,2,3,4,5,6)
    println(highFunc({x, y, -> x + y}, 10, 20))

    val lamdaVal = {x: Int, y: Int -> x * y}
    println(lamdaVal(2, 5))
}