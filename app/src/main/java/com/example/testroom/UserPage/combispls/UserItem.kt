package com.example.testroom.UserPage.combispls

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.testroom.R
import com.example.testroom.UserPage.data.entity.UserEntity

@Composable
fun UserItem(user: UserEntity) {
   Card(modifier = Modifier
       .background(Color.White)
       .fillMaxWidth(), elevation = 8.dp) {
       Row() {
           Image(painterResource(R.drawable.ic_launcher_foreground),
               contentDescription =""
           )
           Column() {
               Text(text = user.name)
               Text(text = user.phonNumber)
           }
       }
   }
}