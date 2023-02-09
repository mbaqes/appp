package com.example.testroom.UserPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testroom.UserPage.combispls.UserItem
import com.example.testroom.UserViewModel
import com.example.testroom.core.Recourc
import com.example.testroom.UserPage.data.entity.UserEntity
import com.example.testroom.ui.theme.TestRoomTheme

// User Page ,,,,, List ,, Button For Fatch data from DB ROOM
@Composable
fun UserPage() {
    val vm :UserViewModel = viewModel<UserViewModel>()
    val state  =  vm.state.collectAsState().value

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)) {it.calculateTopPadding()
        Column(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = { vm.getUsers() } // FOR FATCH DATA FROM DATABASE !!
            ) {
             Text(text = "GET USERS")
            }
            when(state){
                is Recourc.Loading<List<UserEntity>> -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                is Recourc.Success<List<UserEntity>> -> {
                    LazyColumn(modifier = Modifier.fillMaxSize(),
                        content = {
                            items(state.data!!.size){index ->
                                UserItem(user=state.data!![index] )
                            }
                        })
                }
                else->{

                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestRoomTheme {
        UserPage()
    }
}








