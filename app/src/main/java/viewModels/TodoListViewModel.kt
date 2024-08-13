package viewModels

import androidx.lifecycle.ViewModel
import data.Todo
import data.apiServices.ApiService
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class TodoListViewModel : ViewModel(), ApiService {
	private val retrofit = Retrofit.Builder()
		.addConverterFactory(ScalarsConverterFactory.create())

	override suspend fun getTodos(apiKey: String, bearerToken: String, userId: String): List<Todo> {
		TODO("Not yet implemented")


	}

	override suspend fun editTodo(
		apiKey: String,
		bearerToken: String,
		userId: String,
		todoId: String,
		todo: Todo
	): Todo {
		TODO("Not yet implemented")
	}

	override suspend fun getUser(apiKey: String) {
		TODO("Not yet implemented")
	}
}