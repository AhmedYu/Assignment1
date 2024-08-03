package accountCreationAndLogin

import LoginCreateAccount.LogInSignUpViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import data.Screens

@Composable
fun AccountView() {
	val navController = rememberNavController()
	val loginSignupViewModel = LogInSignUpViewModel()
	NavHost(navController = navController, startDestination = Screens.SignUpScreen.name) {
	composable(route =  Screens.SignUpScreen.name){

		SignUpScreen {
			navController.navigate(Screens.LoginScreen.name)

		}
	}
		composable(Screens.LoginScreen.name){
			LoginScreen {
				navController.navigate(Screens.SignUpScreen.name)
			}
		}
}
}





