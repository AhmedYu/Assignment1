package com.ahmed.assignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ahmed.assignment1.ui.theme.Assignment1Theme
import com.ahmed.assignment1.ui.theme.PurpleGrey40
import com.ahmed.assignment1.ui.theme.PurpleGrey80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
       
        }
    }
}
//TODO:- Task: Create a composable function for the top bar with the application name
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUI() {
    Assignment1Theme {
        Scaffold(topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "Todo")
            }, colors = TopAppBarDefaults.topAppBarColors(containerColor = PurpleGrey80, contentColorFor(
                PurpleGrey80)),)
        }, modifier = Modifier.fillMaxSize()){innerPadding->
            //TODO:- TOP APP BAR WITH A TODOLIST NAME ON IT
         Column(modifier = Modifier.padding(innerPadding)) {

         }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment1Theme {
MainUI( )
    }
}