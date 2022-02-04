package kopring.start.controller.get

import kopring.start.dto.UserRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController {

    @GetMapping("/hello") // GET http://localhost:8080/hello
    fun hello(): String {
        return "hello kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request mapping"
    }

    @GetMapping("/path/{name}/{age}")
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String {
        println("name = $name")
        println("age = $age")
        return name
    }

    @GetMapping("/res-entity")
    fun returnRequestEntity(): ResponseEntity<String> {
        return ResponseEntity.ok("okok");
    }

    @GetMapping("/query") // name = 김대희, age = 30
    fun queryParam(
        @RequestParam name: String,
        @RequestParam age: Int
    ): String {
        println("name = $name")
        println("age = $age")
        return name
    }

    @GetMapping("/query-object")
    fun queryObjectParam(queryDto: UserRequest): UserRequest {
        println(queryDto)
        return queryDto
    }

    @GetMapping("/query-map")
    fun queryMapParam(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        return map
    }


}