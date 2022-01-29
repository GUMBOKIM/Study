
class Bird2 {
    var name: String
    var wing: Int
    var beak: String
    var color: String

    constructor(name: String, wing: Int, beak: String, color: String) {
        this.name = name
        this.wing = wing
        this.beak = beak
        this.color = color
    }

    constructor(_name: String, _wing: Int, _beak: String) {
        name = _name
        wing = _wing
        beak = _beak
        color = "hihi"
    }

    fun fly() = println("Fly wing: $wing")

    fun sing(vol: Int) = println("Sing vol: $vol")
}

fun main() {
    val coco = Bird2("mybird", 2, "short", "blue")
    println("coco = ${coco.name}")
}