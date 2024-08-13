package viewModels

import UserInterfaces.UserService
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.User
import retrofit2.Call


class RegistrationModelView: ViewModel() , UserService {
val TAG = "Value From TextFields"
	private var  email  = MutableLiveData("")
	private var password = MutableLiveData("")
  var isNameError = MutableLiveData(false)
  var isEmailError = MutableLiveData(false)
	var isPasswordError  = MutableLiveData(false)

	private var name = MutableLiveData("")
	val nameTextFieldValue : LiveData<String> get() = name
	val passwordTextField : LiveData<String> = password
val emailTextField : LiveData<String> = email

	fun updatePassword(value:String){
		password.value = value
	}
	fun updateEmail(value:String){
		email.value = value
	}



	fun validateEntries(): Boolean {
		var valid = true
		Log.d(TAG, "validateEntries: ${emailTextField.value}")
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
	fun updateNameTextFieldValue(value : String){
		name.value = value
	}
	fun createAcount(){
		// TODO: call do the api registration

	}

	override suspend fun registerUser(userRequest: User): Call<User> {
		TODO("Not yet implemented")

	}
}