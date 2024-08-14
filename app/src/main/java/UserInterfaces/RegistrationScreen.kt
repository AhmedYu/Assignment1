package UserInterfaces


import viewModels.CreateAccountViewModel
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
	navigateToLogin: () -> Unit,
	createAccountViewModel: CreateAccountViewModel,
	navigateToTodoListScreen: () -> Unit
) {

	var name by remember {
		mutableStateOf(createAccountViewModel.nameTextFieldValue.value ?: "")
	}
	var email by remember {
		mutableStateOf(createAccountViewModel.emailTextField.value ?: "")
	}
	var password by remember {
		mutableStateOf(createAccountViewModel.passwordTextField.value ?: "")
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

			OutlinedTextField(value = name,
				onValueChange = {
					name = it
					createAccountViewModel.updateNameTextFieldValue(name)


				},
				modifier = Modifier
					.fillMaxWidth(0.9F)
					.padding(horizontal = 1.dp, vertical = 12.dp),
				label = { Text(text = stringResource(id = R.string.nameLable)) },
				placeholder = { Text(text = stringResource(id = R.string.nameLable)) },
				isError = createAccountViewModel.isNameError.value == true,
				supportingText = {
					if (createAccountViewModel.isNameError.value == true) {
						Text(text = stringResource(id = R.string.entry_error_message))
					}
				})

			Spacer(modifier = Modifier.padding(top = 23.dp))

			OutlinedTextField(
				value = email,
				onValueChange = {
					email = it

					createAccountViewModel.updateEmail(email)


				},
				modifier = Modifier
					.fillMaxWidth(0.9F)
					.padding(horizontal = 1.dp, vertical = 12.dp),
				label = { Text(text = stringResource(id = R.string.emailLable)) },
				placeholder = { Text(text = stringResource(id = R.string.emeilPlaceHolder)) },
				isError = createAccountViewModel.isEmailError.value == true,
				supportingText = {
					if (createAccountViewModel.isEmailError.value == true) {
						Text(text = stringResource(id = R.string.entry_error_message))
					}
					if( email.isNotBlank() && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() ){
					  Text(text = stringResource(id = R.string.entry_email_error_message))

				  }
				}
			)

			Spacer(modifier = Modifier.padding(top = 23.dp))

			OutlinedTextField(
				value = password,
				onValueChange = {


					createAccountViewModel.updatePassword(it)
					password = it
				},
				modifier = Modifier
					.fillMaxWidth(0.9F)
					.padding(horizontal = 1.dp, vertical = 12.dp),
				label = { Text(text = stringResource(id = R.string.passwordLable)) },
				placeholder = { Text(text = stringResource(id = R.string.passwordPlaceHolder)) },
				visualTransformation = PasswordVisualTransformation(),
				isError = createAccountViewModel.isPasswordError.value == true,
				supportingText = {
					if (createAccountViewModel.isPasswordError.value == true) {
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
					if (createAccountViewModel.validateEntries()) {
						// Proceed with account creation
						createAccountViewModel.createAcount()
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

		DisplayAlertForEmptyEntry(
			displayAlert = displayAlert, message = stringResource(
				id = R.string.emptyEntryMessage
			)

		) {
			createAccountViewModel.resetErrors()
			displayAlert = false


		}


	}


}


//Done