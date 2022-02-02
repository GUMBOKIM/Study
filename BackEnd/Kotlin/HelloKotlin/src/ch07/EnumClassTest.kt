interface Score {
    fun getScore(): Int
}

enum class MemberType(var prio: String) : Score {
    NORMAL("Third"){
        override fun getScore(): Int = 100
    },
    SILVER("Second"){
        override fun getScore(): Int = 500
    },
    GOLD("First"){
        override fun getScore(): Int = 1500
    }
}

fun main(){
    println(MemberType.NORMAL.getScore())
}