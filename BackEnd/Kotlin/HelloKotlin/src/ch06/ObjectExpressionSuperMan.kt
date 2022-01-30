open class Superman(){
    fun work() = println("taking photos")
    fun talk() = println("taking with people")
    open fun fly() = println("Flying in the air.")
}

fun main() {
    val pretendedMan = object: Superman() {
        override fun fly() = println("I'm not a real superman. I cant fly!")
    }
    pretendedMan.work()
    pretendedMan.talk()
    pretendedMan.fly()
}