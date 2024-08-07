package AccountCreationAndLogin


import LoginCreateAccount.LogInSignUpViewModel
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ahmed.assignment1.R
import com.ahmed.assignment1.ui.theme.Purple40
import kotlin.math.log

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  CreateAccountView( navigateToLogin : ()-> Unit) {
	var loginSingUpViewModel = LogInSignUpViewModel()

	Scaffold(topBar = {
		TopAppBar(title = {
			Text(
				modifier = Modifier.fillMaxWidth(),
				textAlign = TextAlign.Center,
				fontWeight = FontWeight.Bold,
				text =  "Login "
			)
		})
	}, containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(23.dp)) { innerPadding ->
		Column(
			modifier = Modifier
				.padding(innerPadding)
				.fillMaxWidth()
				.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
		) {
			OutlinedTextField(
				value = "",
				onValueChange = {

				},
				modifier = Modifier
					.fillMaxWidth(0.9F)
					.padding(horizontal = 1.dp, vertical = 12.dp),
				label = { Text(text = stringResource(id = R.string.nameLable)) },
				placeholder = {
					Text(text = stringResource(id = R.string.nameLable))
				})
			Spacer(modifier = Modifier.padding(top = 23.dp))
			OutlinedTextField(
				value = "",
				onValueChange = {

				},
				modifier = Modifier
					.fillMaxWidth(0.9F)
					.padding(horizontal = 1.dp, vertical = 12.dp),
				label = { Text(text = stringResource(id = R.string.emailLable)) },
				placeholder = {
					Text(text = stringResource(id = R.string.emeilPlaceHolder))
				})

			Spacer(modifier = Modifier.padding(top = 23.dp))
			OutlinedTextField(
				value = "",
				onValueChange = { },
				modifier = Modifier
					.fillMaxWidth(0.9F)
					.padding(horizontal = 1.dp, vertical = 12.dp),
				label = { Text(text = stringResource(id = R.string.passwordLable)) },
				placeholder = {
					Text(text = stringResource(id = R.string.passwordPlaceHolder))
				},
				visualTransformation = PasswordVisualTransformation()
			)
			Spacer(modifier = Modifier.padding(top = 40.dp))
			Button(modifier = Modifier
				.fillMaxWidth(0.9F)
				.padding(horizontal = 16.dp, vertical = 12.dp),
				colors = ButtonDefaults.buttonColors(containerColor = Purple40),
				onClick = {

				}) {
				Text(text = stringResource(id = R.string.createBTN))
			}
			Spacer(modifier = Modifier.padding(top = 23.dp))

			OutlinedButton(
				modifier = Modifier
					.fillMaxWidth(0.9F)
					.padding(horizontal = 16.dp, vertical = 12.dp), onClick =  navigateToLogin) {
//text on the button
				Text(text = stringResource(id = R.string.loginBTN))
			}

		}

	}
}