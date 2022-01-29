
class Bird5(var name: String, var wing: Int, var beak: String, var color: String) {

    // 객체 생성시 호출
    init {
        println("-------- Start ---------")
        println("이름은 $name, 부리는 $beak")
        println("--------  End  ---------")
    }

    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

fun main() {
    val coco = Bird5("mybird", 2, "short", "blue")
    println("coco = ${coco.name}")
}