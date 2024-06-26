package com.ahmed.assignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmed.assignment1.ui.theme.Assignment1Theme
import com.ahmed.assignment1.ui.theme.Purple40
import com.ahmed.assignment1.ui.theme.PurpleGrey80

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            MainUI()
        }
    }
}
//TODO:- Task: Create a composable function for the top bar with the application name
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUI() {
    var showBSheet  by remember {
        mutableStateOf(value = false)
    }
    Assignment1Theme {
        Scaffold(topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "Todo")
            }, colors = TopAppBarDefaults.topAppBarColors(containerColor = PurpleGrey80, contentColorFor(
                PurpleGrey80)),)
        }, floatingActionButton =
        {
          FloatingActionBtn(isBtSheetShown = showBSheet) {

          }
        }, modifier = Modifier.fillMaxSize()){ innerPadding->
            //TODO:- TOP APP BAR WITH A TODOLIST NAME ON IT
         Column(modifier = Modifier.padding(innerPadding)) {

         }

        }
    }
}
@Composable fun FloatingActionBtn(isBtSheetShown : Boolean, showbuttonSheet : ()-> Unit){

    FloatingActionButton(modifier = Modifier
        .shadow(12.dp, shape = RoundedCornerShape(19.dp)) , containerColor = Color(red = 232, green = 210, blue = 255),
onClick = showbuttonSheet ) {


        Icon(modifier = Modifier

            .fillMaxWidth(.1f), painter = painterResource(id = R.drawable.add_icon), contentDescription = "add")


    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment1Theme {
MainUI( )
    }
}