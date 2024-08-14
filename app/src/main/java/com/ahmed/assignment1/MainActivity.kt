package com.ahmed.assignment1


import viewModels.GeneralViewModel
 import UserInterfaces.RegistrationLoginNavigation
 import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {

		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
Main()
		}
	}
}
@Composable
fun Main(){
	val generalModelView = GeneralViewModel()
	val navController  = rememberNavController()


RegistrationLoginNavigation()

}