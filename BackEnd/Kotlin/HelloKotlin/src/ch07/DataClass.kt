data class Customer(var name: String, var email: String){
    var job: String = "Unkown"
    constructor(name:String, email: String, _job: String): this(name, email) {
        job = _job
    }
    init {

    }
}

fun main() {
    val customer1 = Customer("sean", "sean@mail.com")
    val customer2 = Customer("sean", "sean@mail.com")
    println(customer1 == customer2)
    println(customer1.equals(customer2))
    println(customer1.hashCode())
}