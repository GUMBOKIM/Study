
fun main() {

    retFunc()

}

fun retFunc() {
    println("start of retFunc")
    inlineLambda(10, 3) lit@{ a, b ->
        val result = a + b
        if(result > 10) return@lit
        println("result : $result")
    }
    println("end")
}

fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}
