import data.todoList

data class Todo(var name: String, var isDone: Boolean)

fun createNewTodoIem(entry: String) {

	todoList.add(Todo(entry, false))
}