package AccountCreationAndLogin

import LoginCreateAccount.LogInSignUpViewModel
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlin.math.log

@Composable
fun AccountView() {
	val navController = rememberNavController()
	val loginSignupViewModel = LogInSignUpViewModel()
	NavHost(navController = navController, startDestination = "CreateAccountView") {
	 composable("CreateAccountView"){
		 CreateAccountView {
			 navController.navigate("LoginScreen")
		 }
	 }
		composable("LoginScreen"){
		 CreateAccountView {
			 navController.navigate("CreateAccountView")
		 }
	 }


	}
}





