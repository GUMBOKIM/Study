package kopring.start.controller.exception

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
@AutoConfigureMockMvc
class ExceptionApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun helloTest(){
        mockMvc.perform(
            get("/api/exception/hello")
        ).andExpect{
            status().isOk
        }.andExpect(
            content().string("hello")
        ).andDo(
            print()
        )
    }
}