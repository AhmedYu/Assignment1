package UserInterfaces

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ahmed.assignment1.R
import com.ahmed.assignment1.ui.theme.Assignment1Theme
import com.ahmed.assignment1.ui.theme.PurpleGrey80
import components.BtmContent
import components.DisplayFloatingActionBtn
import components.IndividualRow
import data.changeTodoStatus
import data.todoList


/**
 * the function creates the app entry point by calling individual UI Components
 * The components are in Component package
 *          -contains :
 *              -Buttons
 *              -UI view Functions
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListScreen() {
	//check box flag to set the todo item's completion status
	var isDone by remember {
		mutableStateOf(false)
	}

	val sheetState = rememberModalBottomSheetState()
	var isBtSheetShown by remember { //to dismiss the btm sheet and show it
		mutableStateOf(false)
	}
	//stores value from the text field
	var entry by remember {
		mutableStateOf("")
	}
	var isDisplayErrorMessage by remember { //to display error messages when it is true
		mutableStateOf(
			false
		)
	}


	Assignment1Theme {
		Scaffold(
			topBar = {
				CenterAlignedTopAppBar(
					title = {
						Text(text = stringResource(id = R.string.top_bar_title))
					},
					colors = TopAppBarDefaults.topAppBarColors(
						containerColor = PurpleGrey80,
						contentColorFor(
							PurpleGrey80
						)
					),
				)
			}, floatingActionButton =
			{

				DisplayFloatingActionBtn {
					isBtSheetShown = true
				}
			}, modifier = Modifier.fillMaxSize()
		) { innerPadding ->
			//TODO:- TOP APP BAR WITH A TODOLIST NAME ON IT
			LazyColumn(
				modifier = Modifier
					.padding(innerPadding)
					.padding(12.dp)
			) {

				item {
					for (item in todoList) {
						Row(
							modifier = Modifier

								.fillMaxWidth()
								.background(color = PurpleGrey80),
							verticalAlignment = Alignment.CenterVertically,
							horizontalArrangement = Arrangement.Center
						)
						{
							isDone = item.isDone //isolates each items doneStatus so that when
							IndividualRow(item = item, isDone = isDone) {
								isDone = it
								changeTodoStatus(item)
							}


						}
					}


				}
			}

		}
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.9F)
		) {
			if (isBtSheetShown) {
				ModalBottomSheet(
					modifier = Modifier.background(color = colorResource(id = R.color.bottom_sheet_color)),
					windowInsets = WindowInsets.ime,


					onDismissRequest = {
						isBtSheetShown = false
					}, sheetState = sheetState
				) {

					//the content goes here.
					BtmContent(
						changeDisplayErrorText = { isDisplayErrorMessage = it },
						changeBtmSheetStatus = { isBtSheetShown = false },
						entry = entry, isBtSheetShown = isBtSheetShown,
						isDisplayErrorMessage = isDisplayErrorMessage
					) {
						entry = it
					}
				}
			}
		}
	}
}




