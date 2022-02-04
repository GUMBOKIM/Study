package kopring.todo.repository

import kopring.todo.database.Todo
import kopring.todo.database.TodoDataBase
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDateTime

class TodoRepositoryImpl : TodoRepository {

    @Autowired
    lateinit var todoDataBase: TodoDataBase

    override fun save(todo: Todo): Todo {
        return todo.apply {
            this.index = ++todoDataBase.index
            this.createdAt = LocalDateTime.now()
            this.updatedAt = LocalDateTime.now()
        }.run {
            todoDataBase.todoList.add(todo)
            this
        }
    }

    override fun saveAll(todoList: MutableList<Todo>): Boolean {
         return try{
             todoList.forEach{
                 save(it)
             }
             true
         } catch (e:Exception){
             false
         }
    }

    override fun update(todo: Todo): Todo {
        TODO("Not yet implemented")
    }

    override fun delete(index: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun findOne(index: Int): Todo {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<Todo> {
        TODO("Not yet implemented")
    }
}