fun main() {

    for(i in 1..5){
        if (i == 3) break;
        println(i)
    }
    println("-----------------")

    for(i in 1..5){
        for(j in 1..5){
            if(j == 3) break
            println("i = $i, j = $j")
        }
        println("after j")
    }
    println("after i")

    println("-----------------")

    first@ for(i in 1..5){
        for(j in 1..5){
            if(j == 3) break@first
            println("i = $i, j = $j")
        }
        println("after j")
    }
    println("after i")

    println("-----------------")

    first@ for(i in 1..5){
        for(j in 1..5){
            if(j == 3) continue@first
            println("i = $i, j = $j")
        }
        println("after j")
    }
    println("after i")

    println("-----------------")


}
