package kopring.start.controller.validate

import kopring.start.dto.UserRequest
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api")
@Validated
class ValidationApiRestController {

    @PutMapping("/val")
    fun validationMapping(
        @Size(min = 2, max = 5, message = "가능한 길이는 2 ~ 5글자 입니다.")
        @RequestParam(value = "name") _name: String,

        @javax.validation.constraints.NotNull(message = "age값이 누락되었습니다.")
        @Min(value = 20, message = "age는 20보다 커야 합니다.")
        @RequestParam(name = "age") _age: Int
    ): String {
        println("_name = $_name")
        println("_age = $_age")
        return _name + _age
    }

    @PutMapping("/val")
    fun validationObjectMapping(
        @Valid @RequestBody userRequest: UserRequest, bindingResult: BindingResult
    ): ResponseEntity<String?> {
        if (bindingResult.hasErrors()) {
            val msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append("${field.field} : $message\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }
        return ResponseEntity.ok(null)
    }

}