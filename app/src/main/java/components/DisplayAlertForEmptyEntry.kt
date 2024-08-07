package components
import android.graphics.drawable.Icon
import com.ahmed.assignment1.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ahmed.assignment1.R.drawable.warning

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun DisplayAlertForEmptyEntry(displayAlert: Boolean, message: String, dismiss: () -> Unit) {
	if (displayAlert) {
 AlertDialog(
	 icon = {
		 androidx.compose.material3.Icon(painter = painterResource(id = warning), contentDescription = "warning icon", tint = Color.Red, modifier = Modifier.size(width = 40.dp, height = 40.dp))
	 },
	 title = {
	 Text(text = stringResource(id = R.string.entry_error_message))
 }, text = {Text( text = stringResource(id = R.string.emptyEntryMessage ))},
	 onDismissRequest = {
dismiss()
	 },   confirmButton = {

	 }, dismissButton = {
		 TextButton(modifier = Modifier.fillMaxWidth(.9F), onClick = dismiss) {
			 Text(text = stringResource(id = R.string.ok))
			 
		 }
	 })
	}
}