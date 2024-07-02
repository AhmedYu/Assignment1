import data.todoList
//data class for the todo list
data class TodoItem(var name: String, var isDone: Boolean)

/**
 * create a new todoItem
 * @param entry : a string value
 * returns nothing
 */
fun createNewTodoIem(entry: String) {

	todoList.add(TodoItem(entry, false))
}