package kopring.start.controller.post

import kopring.start.dto.UserRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PostApiController {

    @PostMapping("/post-mapping") // GET http://localhost:8080/hello
    fun postMapping(): String {
        return "post-mapping"
    }

    // object mapper
    // json -> object
    // object -> json

    @PostMapping("/post-object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        println("userRequest = $userRequest")
        return userRequest
    }



}