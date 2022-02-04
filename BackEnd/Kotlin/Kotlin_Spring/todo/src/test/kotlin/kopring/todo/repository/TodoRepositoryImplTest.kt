package kopring.todo.repository

import kopring.todo.config.AppConfig
import kopring.todo.database.Todo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest(classes = [TodoRepositoryImpl::class, AppConfig::class])
internal class TodoRepositoryImplTest {

    @Autowired
    lateinit var todoRepositoryImpl: TodoRepositoryImpl

    @Test
    fun save() {
        val todo = Todo().apply {
            this.title = "테스트 일정"
            this.description = "테스트"
            this.schedule = LocalDateTime.now()
        }

        val result = todoRepositoryImpl.save(todo)
        Assertions.assertEquals(1, result.index)
        Assertions.assertNotNull(result.createdAt)
        Assertions.assertNotNull(result.updatedAt)
        Assertions.assertEquals("테스트 일정", result.title)
        Assertions.assertEquals("테스트", result.description)
    }

    @Test
    fun saveAll() {
    }

    @Test
    fun update() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun findOne() {
    }

    @Test
    fun findAll() {
    }
}