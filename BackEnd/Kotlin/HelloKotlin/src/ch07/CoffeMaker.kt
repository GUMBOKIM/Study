class CoffeMaker(val coffeeModule: CoffeeModule){
    fun brew() {
        val theSiphon : Thermosiphon = coffeeModule.getThermosiphon()
        theSiphon.on()
        theSiphon.pump()
        println("Coffee, here! Enjoy!~")
        theSiphon.off()
    }
}

fun main() {
    val coffeeMaker = CoffeMaker(MyDripCoffeModule())
    coffeeMaker.brew()
}