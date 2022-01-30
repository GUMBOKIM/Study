sealed class Result {
    open class Success(val message: String) : Result()
    class Error(val code: Int, val message: String) : Result()
}

class Status: Result()
class Inside: Result.Success("status")