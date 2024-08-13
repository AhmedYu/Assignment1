package com.ahmed.assignment1


import viewModels.GeneralViewModel
import UserInterfaces.AccountView
import viewModels.RegistrationModelView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
private var loginSignUpModelView = RegistrationModelView()

	override fun onCreate(savedInstanceState: Bundle?) {

		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
AccountView()
		}
	}
}
@Composable
fun Main(){
	val generalModelView = GeneralViewModel()
	val navController  = rememberNavController()




}