package ModelViews

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.User
import kotlinx.coroutines.flow.MutableStateFlow

class LogInSignUpViewModel: ViewModel() {
    var navigateToLogin  : MutableLiveData<Boolean> = MutableLiveData(false)
	val user : MutableLiveData<User> = MutableLiveData()


}