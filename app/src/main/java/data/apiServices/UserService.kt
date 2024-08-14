package data.apiServices

import retrofit2.http.Body

import data.User
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService {
	@Headers("apikey: 2e1fa387-fe0e-47ad-b2c6-e0c2483f3fe8")
	@POST("users/register")

public suspend fun registerUser(@Body userRequest: User): Call<User>
}
