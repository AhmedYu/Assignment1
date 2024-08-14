package UserInterfaces

import viewModels.CreateAccountViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import data.Screens
import viewModels.LogInViewMode

@Composable
fun RegistrationLoginNavigation() {
	val logInViewMode = LogInViewMode()
	val navController = rememberNavController()
	val createAccountViewModel = CreateAccountViewModel()
	NavHost(navController = navController, startDestination = "RegistrationScreen") {
		composable("RegistrationScreen") {
			RegistrationScreen(navigateToLogin = {
				navController.navigate(Screens.LoginScreen.name)
			}, createAccountViewModel, navigateToTodoListScreen = {
				navController.navigate(Screens.TodoListScreen.name)
			})

		}
		composable("LoginScreen") {
			LoginScreen(toSignUpScreen = { navController.navigate(Screens.RegistrationScreen.name) }, logInViewMode = logInViewMode) {
				navController.navigate(Screens.TodoListScreen.name)
			}
		}

		composable(Screens.TodoListScreen.name) {
			TodoListScreen()
		}

	}
}





