package kopring.todo.config

import kopring.todo.database.TodoDataBase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean(initMethod = "init")
    fun todoBataBase(): TodoDataBase {
        return TodoDataBase()
    }

}