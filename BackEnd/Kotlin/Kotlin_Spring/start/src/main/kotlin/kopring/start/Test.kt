package kopring.start

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@Service
class StartApplication



fun main(args: Array<String>) {
    runApplication<StartApplication>(*args)
}
