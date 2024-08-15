package viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import data.User

class LogInViewMode(private var user: User) {
	val TAG = "Value From TextFields"
	private var email = MutableLiveData("")
	private var password = MutableLiveData("")
	var isEmailError = MutableLiveData(false)
	var isPasswordError = MutableLiveData(false)

	val passwordTextField: LiveData<String> = password
	val emailTextField: LiveData<String> = email

	fun updatePassword(value: String) {
		password.value = value
	}

	fun updateEmail(value: String) {
		email.value = value
	}

	fun validateEntries(): Boolean {
		var valid = true
		Log.d(TAG, "validateEntries: ${emailTextField.value}")
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

	fun clearTextFields() {

		email.value = ""
		password.value = ""

	}
}