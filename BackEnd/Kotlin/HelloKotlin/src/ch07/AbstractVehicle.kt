abstract class Vehicle(val name: String, val color: String, val weight: Double) {
    abstract var maxSpeed: Double
    var year = "2018"
    abstract fun start()
    abstract fun stop()
    fun displaySpecs() {
        println("Name: $name, Color: $color, Weight: $weight, Year: $year, Max Speed: $maxSpeed")
    }
}

class Sonata(name: String, color: String, weight: Double, override var maxSpeed: Double) :
    Vehicle(name, color, weight) {
    override fun start() {
        println("Car started")
    }

    override fun stop() {
        println("Car stopped")
    }
}

class Kawasaki(name: String, color: String, weight: Double, override var maxSpeed: Double) :
    Vehicle(name, color, weight) {
    override fun start() {
        println("Bike started")
    }

    override fun stop() {
        println("Bike stopped")
    }
}

fun main() {
    val sonata = Sonata("DN8", "yellow", 1110.0, 270.0)
    sonata.year = "2022"
    sonata.displaySpecs()
    sonata.start()
    sonata.stop()

    val kawasaki = Kawasaki("Ninja", "green", 1000.0, 340.0)
    kawasaki.displaySpecs()
    kawasaki.start()
    kawasaki.stop()
}