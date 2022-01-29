
open class Bird6(var name: String, var wing: Int, var beak: String, var color: String) {
    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

class Lark(name: String, wing: Int, beak: String, color: String) : Bird6(name,wing, beak, color){
    fun singHitone() = println("Happy Song")
}

fun main() {
    val coco = Lark("mybird", 2, "short", "blue")
    println("coco = ${coco.name}")
    coco.singHitone()
}