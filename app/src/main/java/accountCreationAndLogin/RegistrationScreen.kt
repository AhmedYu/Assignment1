package accountCreationAndLogin


import LoginCreateAccount.RegistrationModelView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ahmed.assignment1.R
import com.ahmed.assignment1.ui.theme.Purple40
import components.DisplayAlertForEmptyEntry
var registrationModelView = RegistrationModelView()
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(navigateToLogin: () -> Unit, registrationModelView: RegistrationModelView , navigateToTodoListScreen : ()-> Unit ) {

	var name by remember {
		mutableStateOf(registrationModelView.name.value ?: "")
	}
	var email by remember {
		mutableStateOf(registrationModelView.email.value ?: "")
	}
	var password by remember {
		mutableStateOf(registrationModelView.password.value?:"")
	}
	var displayAlert by remember {
		mutableStateOf(false)
	}
	Scaffold(topBar = {
		TopAppBar(title = {
			Text(
				modifier = Modifier.fillMaxWidth(),
				textAlign = TextAlign.Center,
				fontWeight = FontWeight.Bold,
				text = stringResource(id = R.string.app_name)
			)
		})
	}, containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(23.dp)) { innerPadding ->
		Column(
			modifier = Modifier
				.padding(innerPadding)
				.fillMaxWidth()
				.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
		) {

			OutlinedTextField(value = name , onValueChange = {
					name = it
				registrationModelView.name.postValue(it)


			}, modifier = Modifier
				.fillMaxWidth(0.9F)
				.padding(horizontal = 1.dp, vertical = 12.dp), label = { Text(text = stringResource(id = R.string.nameLable)) }, placeholder = { Text(text = stringResource(id = R.string.nameLable)) }, isError = registrationModelView.isNameError.value == true, supportingText = {
					if (registrationModelView.isNameError.value == true) {
						Text(text = stringResource(id = R.string.entry_error_message))
					}
				})

			Spacer(modifier = Modifier.padding(top = 23.dp))

			OutlinedTextField(
				value =  email,
				onValueChange = {
					email = it
					registrationModelView.email.postValue(it)


				},
				modifier = Modifier
					.fillMaxWidth(0.9F)
					.padding(horizontal = 1.dp, vertical = 12.dp),
				label = { Text(text = stringResource(id = R.string.emailLable)) },
				placeholder = { Text(text = stringResource(id = R.string.emeilPlaceHolder)) },
				isError = registrationModelView.isEmailError.value == true,
				supportingText = {
					if (registrationModelView.isEmailError.value == true) {
						Text(text = stringResource(id = R.string.entry_error_message))
					}
				}
			)

			Spacer(modifier = Modifier.padding(top = 23.dp))

			OutlinedTextField(
				value = password,
				onValueChange = {


					registrationModelView.password.value = it
					password = it
				},
				modifier = Modifier
					.fillMaxWidth(0.9F)
					.padding(horizontal = 1.dp, vertical = 12.dp),
				label = { Text(text = stringResource(id = R.string.passwordLable)) },
				placeholder = { Text(text = stringResource(id = R.string.passwordPlaceHolder)) },
				visualTransformation = PasswordVisualTransformation(),
				isError = registrationModelView.isPasswordError.value == true,
				supportingText = {
					if (registrationModelView.isPasswordError.value == true) {
						Text(text = stringResource(id = R.string.entry_error_message))
					}
				}
			)

			Spacer(modifier = Modifier.padding(top = 40.dp))
			Button(
				modifier = Modifier
					.fillMaxWidth(0.9F)
					.padding(horizontal = 16.dp, vertical = 12.dp),
				colors = ButtonDefaults.buttonColors(containerColor = Purple40),
				onClick = {
					if (registrationModelView.validateEntries()) {
						// Proceed with account creation
						registrationModelView.createAcount()
					displayAlert = false
						navigateToTodoListScreen()


					} else {

						displayAlert = true
					}
				}
			) {
				Text(text = stringResource(id = R.string.createBTN))
			}

			Spacer(modifier = Modifier.padding(top = 23.dp))

			OutlinedButton(
				modifier = Modifier
					.fillMaxWidth(0.9F)
					.padding(horizontal = 16.dp, vertical = 12.dp), onClick = navigateToLogin
			) {
				Text(text = stringResource(id = R.string.loginBTN))
			}



		}

		DisplayAlertForEmptyEntry(displayAlert =  displayAlert, message = stringResource(
			id = R.string.emptyEntryMessage
		)

		) {
			displayAlert = false


		}

	}



}


