package kopring.start.controller.put

import kopring.start.dto.Result
import kopring.start.dto.UserRequest
import kopring.start.dto.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String{
        return "put-mapping"
    }

    @PutMapping("/put-object")
    fun putMapping(@RequestBody userRequest: UserRequest): UserResponse {
        return UserResponse().apply {
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            this.description = "~~~~~~~~~~~~"
        }.apply {
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(userRequest)
            userList.add(userRequest)
            userList.add(userRequest)
            userList.add(userRequest)
            this.userRequest = userList
        }
    }

}