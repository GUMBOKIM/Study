
class Bird {
    var name: String = "my bird"
    var wing: Int = 2
    var beak: String = "short"
    var color: String = "blue"

    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

fun main() {
    val coco = Bird()
    coco.color = "blue"

    println("color : ${coco.color}")
    coco.fly()
    coco.sing(3)
}