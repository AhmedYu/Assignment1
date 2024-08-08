package LoginCreateAccount

import accountCreationAndLogin.UserService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.Screens
import data.User
import retrofit2.Call


class RegistrationModelView: ViewModel() , UserService {

	var name = MutableLiveData("")
	var email  = MutableLiveData("")
	var password = MutableLiveData("")
	var startScreen = Screens.RegistrationScreen
 	var isNameError = MutableLiveData(false)
	var isEmailError = MutableLiveData(false)
	var isPasswordError  = MutableLiveData(false)

	fun validateEntries(): Boolean {
		var valid = true

		if (name.value.isNullOrEmpty()) {
			isNameError.value = true
			valid = false
		}
		if (email.value.isNullOrEmpty()) {
			isEmailError.value = true
			valid = false
		}
		if (password.value.isNullOrEmpty()) {
			isPasswordError.value = true
			valid = false
		}
		return valid
	}

	fun resetErrors() {
		isNameError.value = false
		isEmailError.value = false
		isPasswordError.value = false
	}
	fun createAcount(){
		// TODO: call do the api registration

	}

	override suspend fun registerUser(userRequest: User): Call<User> {
		TODO("Not yet implemented")

	}
}