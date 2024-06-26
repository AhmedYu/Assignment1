package Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ahmed.assignment1.R

@Composable

fun DisplayFloatingActionBtn(isBtSheetShown : Boolean, showbuttonSheet : ()-> Unit){

    FloatingActionButton(modifier = Modifier
        .shadow(12.dp, shape = RoundedCornerShape(19.dp)) ,
        containerColor = Color(red = 232, green = 210, blue = 255),
        onClick = showbuttonSheet ) {
        Icon(modifier = Modifier.fillMaxWidth(.1f),
            painter = painterResource(id = R.drawable.add_icon),
            contentDescription = "add")


    }
}