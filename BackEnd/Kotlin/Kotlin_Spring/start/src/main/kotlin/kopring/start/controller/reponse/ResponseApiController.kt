package kopring.start.controller.reponse

import kopring.start.dto.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    // 1. get 4xx
    @GetMapping("")
    fun getMapping(@RequestParam(required = false) age: Int?): ResponseEntity<String> {

        return age?.let {
            if (age < 20) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age 값은 20보다 커야합니다.")
            return ResponseEntity.ok("OK")
        } ?: kotlin.run {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age 값이 누락 됬습니다.")
        }
//        // 1. age == null -> 400 Error
//        if (age == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age 값이 누락 됬습니다.")
//        else if (age < 20) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age 값은 20보다 커야합니다.")
//        // 2. age <>> 20 -> 400 Error
//        println(age)
//        return ResponseEntity.ok("OK")
    }

    // 2. post 200
    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        return ResponseEntity.status(200).body(userRequest)
    }

    // 3. put 201
    @PutMapping("")
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    // 4. delete 500
    @DeleteMapping("")
    fun deleteMapping(): String {
        return "put-mapping"
    }
}