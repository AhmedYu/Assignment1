package data

var todoList: MutableList<Todo> = mutableListOf(
	Todo("Assignment1", true),
	Todo("Assignment2", false),
	Todo("Review Kotlin notes", false),
	Todo("Finish project report", true),
	Todo("Prepare presentation", false),
	Todo("Study for exams", true),
	Todo("Complete lab exercise", false),
	Todo("Read chapter 4", true),
	Todo("Practice coding", false),
	Todo("Meet with study group", true),
	Todo("Submit homework", false),
	Todo("Update resume", true),
	Todo("Plan weekend trip", false),
	Todo("Buy groceries", true)
)

fun changeTodoStatus(item: Todo) {
	// TODO: find the element
	val indexOfEleemt = todoList.indexOf(item)
	val modifiedItem = Todo(item.name, !item.isDone)
//    var itemToUpdate = Todo(ite, oldCompletionStatus )
	todoList.set(indexOfEleemt, modifiedItem)


}