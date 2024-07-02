package data

import TodoItem

var todoList: MutableList<TodoItem> = mutableListOf(
	TodoItem("Assignment1", true),
	TodoItem("Assignment2", false),
	TodoItem("Review Kotlin notes", false),
	TodoItem("Finish project report", true),
	TodoItem("Prepare presentation", false),
	TodoItem("Study for exams", true),
	TodoItem("Complete lab exercise", false),
	TodoItem("Read chapter 4", true),
	TodoItem("Practice coding", false),
	TodoItem("Meet with study group", true),
	TodoItem("Submit homework", false),
	TodoItem("Update resume", true),
	TodoItem("Plan weekend trip", false),
	TodoItem("Buy groceries", true)
)

fun changeTodoItemStatus(item: TodoItem) {
	// TODO: find the element
	val indexOfEleemt = todoList.indexOf(item)
	val modifiedItem = TodoItem(item.name, !item.isDone)
//    var itemToUpdate = TodoItem(ite, oldCompletionStatus )
	todoList.set(indexOfEleemt, modifiedItem)


}