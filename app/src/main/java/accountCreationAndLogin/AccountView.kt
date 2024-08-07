package accountCreationAndLogin

import LoginCreateAccount.RegistrationModelView
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import data.Screens

@Composable
fun AccountView() {
	val navController = rememberNavController()
	val registrationModelView = RegistrationModelView()
	NavHost(navController = navController, startDestination = "RegistrationScreen") {
	 composable("RegistrationScreen"){
		 RegistrationScreen(navigateToLogin = {
			 navController.navigate(Screens.LoginScreen.name)
		 }, registrationModelView = registrationModelView )

	 }
		composable("LoginScreen"){
		 accountCreationAndLogin.LoginScreen {
			 navController.navigate("RegistrationScreen")
		 }
	 }


	}
}





