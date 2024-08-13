package UserInterfaces

import viewModels.RegistrationModelView
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
		 }, registrationModelView = registrationModelView , navigateToTodoListScreen = {
			 navController.navigate(Screens.TodoListScreen.name)
		 })

	 }
		composable("LoginScreen"){
		 LoginScreen(toSignUpScreen = {navController.navigate(Screens.RegistrationScreen.name) }) {
			 navController.navigate(Screens.TodoListScreen.name)
		 }
	 }

composable(Screens.TodoListScreen.name){
	TodoListScreen()
}

	}
}





