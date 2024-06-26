package Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import TodoItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.MaterialTheme
import com.ahmed.assignment1.ui.theme.PurpleGrey80

@Composable
fun IndividualRow(todoItem : TodoItem, togleDone: ()-> Unit){
    Row(modifier = Modifier

        .fillMaxWidth()
        .background(color = PurpleGrey80),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center)
    {
        Text(text = todoItem.name, modifier = Modifier.fillMaxWidth(.88f).padding(start = 5.dp))
        Checkbox(modifier = Modifier, enabled = true, checked = todoItem.isDone, onCheckedChange ={togleDone} )


    }
}