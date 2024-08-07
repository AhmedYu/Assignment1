package LoginCreateAccount

import data.Todo
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
public suspend fun getTodos(@Query("apiKey") apiKey:String,
							@Header("Authorization") bearerToken: String,
							@Path("userId") userId: String):List<Todo>
public suspend fun editTodo(
	@Query("apiKey") apiKey:String,
	@Header("Authorization") bearerToken: String,
	@Path("userId") userId: String,
	@Path("todoId") todoId:String,
	@Body todo:Todo
):Todo
public suspend fun getUser(@Query("apiKey")  apiKey: String,
						   )
}