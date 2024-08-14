package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ahmed.assignment1.R
import com.ahmed.assignment1.ui.theme.Purple40
import data.createNewTodoIem

@Composable
fun BtmContent(
	changeDisplayErrorText: (Boolean) -> Unit,
	changeBtmSheetStatus: (Boolean) -> Unit,
	entry: String, isDisplayErrorMessage: Boolean, isBtSheetShown: Boolean,
	changeEntry: (String) -> Unit
) {

	Column(
		modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(top = 12.dp),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.spacedBy(20.dp)
	) {
		OutlinedTextField(modifier = Modifier.fillMaxWidth(0.9F),
			colors = OutlinedTextFieldDefaults.colors(


				errorBorderColor = (if (entry.isEmpty()) Color.Red else Color.Gray),
			),
			//trailing icon to clear the text entred
			trailingIcon = {
				IconButton(onClick = { changeEntry("") }) {
					Icon(
						painter = painterResource(id = R.drawable.cancell),
						contentDescription = stringResource(id = R.string.x_icon_text), tint =
						(if (isDisplayErrorMessage && entry.isEmpty()) Color.Red else Color.Gray)
					)
				}
			},
			value = entry,
			isError = isDisplayErrorMessage,
			//error messge is displayed by the supportingtext
			// when the isDisplayErroreMeassge is true and entry is empty
			supportingText = {

				if (isDisplayErrorMessage && entry.isEmpty()) Text(
					modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.error,
					text = stringResource(id = R.string.entry_error_message)
				)


			},
			onValueChange = changeEntry,
			placeholder = {
				Text(text = stringResource(id = R.string.textField_placeholder))
			})


		Button(modifier = Modifier
            .fillMaxWidth(0.9F)
            .padding(horizontal = 16.dp, vertical = 12.dp),
			colors = ButtonDefaults.buttonColors(containerColor = Purple40),
			onClick = {
				//create new item withe the new entry
				if (entry.isEmpty()) {

					changeDisplayErrorText(true)
				} else {

					changeEntry(entry) //change the entry status with the value
					changeBtmSheetStatus(false) //set btmsheet status to dismiss it.
					createNewTodoIem(entry) //create the
					changeEntry("") //cleat the entry
					changeDisplayErrorText(false) //reset the error message flag to false
				}

			}) {
			Text(text = stringResource(id = R.string.save_button))
		}
		OutlinedButton(modifier = Modifier.fillMaxWidth(0.84F), onClick = {
			changeEntry("") //clear the entry
			changeDisplayErrorText(false) //set the error display flag to false.
			changeBtmSheetStatus(false) //dismmis the bottom sheet
		}) {
//text on the button
			Text(text = stringResource(id = R.string.cancel_button))
		}


	}

}
