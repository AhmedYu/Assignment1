package LoginCreateAccount

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.Screens
import data.User

class LogInSignUpViewModel: ViewModel() {
	val user : MutableLiveData<User> = MutableLiveData()
	var name : MutableLiveData<String> = MutableLiveData()
	var email : MutableLiveData<String> = MutableLiveData()
	var passwaord : MutableLiveData<String> = MutableLiveData()
	var startScreen = Screens.SignUpScreen



	fun collectEntry(){

	}

}