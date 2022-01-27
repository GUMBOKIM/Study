package ch02


fun main() {
    var str1: String = "Hello Kotlin"

//    str1 = null null을 허용하지 않음
    println("str1 : ${str1.length}") // null 허용하지 않으면 length 사용 가능
    var str2: String? = "Hello Kotlin"

    str2 = null // ? 는 null 허용
    println("str2 : $str2")
//    println("length: ${str2.length}") // null 허용하면 length를 사용할 수 없음
    println("length: ${str2?.length}") // safe call(?) 사용하여 안전하게 호출

    var str3 : String? = "Hello Kotlin"
    str3 = null
    // 조건식을 통해서 null 상태 검사
    var len = if(str3 != null) str3.length else -1
    println("str3: $str3 length: ${len}")

    var str4 : String? = "Hello Kotlin"
    str4 = null
    // 조건식을 통해서 null 상태 검사
    println("str4: $str4 length: ${str4?.length ?: -1}") // 엘비스 연산자

}