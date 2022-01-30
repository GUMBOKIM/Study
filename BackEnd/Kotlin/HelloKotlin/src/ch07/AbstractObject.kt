abstract class Printer {
    abstract fun print()
}

val myPrinter = object: Printer() {
    override fun print() {
        println("출력합니당")
    }
}

fun main() {
    myPrinter.print()
}