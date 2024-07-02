import data.todoList

data class TodoItem(var name: String, var isDone: Boolean)

fun createNewTodoIem(entry: String) {

	todoList.add(TodoItem(entry, false))
}