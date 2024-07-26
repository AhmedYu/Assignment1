package AccountCreationAndLogin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ahmed.assignment1.R
import com.ahmed.assignment1.ui.theme.Purple40

@Composable
fun LoginScreen(){
	Column {

		OutlinedTextField(value = "", onValueChange = { 
			
		}, label = {Text(text = stringResource(id = R.string.emailLable))})
	  
Spacer(modifier = Modifier.padding(vertical = 23.dp))
		OutlinedTextField(value = "", onValueChange = {

		}, label = {Text(text = stringResource(id = R.string.passwordLable))}, placeholder = {
			Text(text = stringResource(id = R.string.passwordPlaceHolder))
		})

		Button(modifier = Modifier
			.fillMaxWidth(0.9F)
			.padding(horizontal = 16.dp, vertical = 12.dp),
			colors = ButtonDefaults.buttonColors(containerColor = Purple40),
			onClick = {
				
			}) {
			Text(text = stringResource(id = R.string.loginBTN))
		}
	}
	
}
 