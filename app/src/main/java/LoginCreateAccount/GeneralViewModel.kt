package LoginCreateAccount

import data.Screens

class GeneralViewModel {
 	val isCustomerNew  = true
	val logInSignUpViewModel = LogInSignUpViewModel()
	fun customerAccountVerification(){
		if(isCustomerNew)
			logInSignUpViewModel.startScreen = Screens.SignUpScreen
	}
}