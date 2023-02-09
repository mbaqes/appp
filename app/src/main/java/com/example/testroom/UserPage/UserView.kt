package com.example.testroom

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import com.example.testroom.core.Recourc
 import com.example.testroom.UserPage.data.entity.UserEntity
import com.example.testroom.UserPage.data.repository.LocalUserRepositoryImps
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow

class UserViewModel() : ViewModel() {
   private val userrepository = LocalUserRepositoryImps()
    private var currnetState = Recourc.Inti<List<UserEntity>>()
    val state = MutableStateFlow<Recourc<List<UserEntity>>>(currnetState)

    fun getUsers() {
        insertUser()
        viewModelScope.launch {
            userrepository.getallUSer().onEach {
                delay(2000)
                state.value = it
            }.launchIn(viewModelScope)
        }

    }

    fun insertUser() {
        viewModelScope.launch {
            for (i in 1..10){
                userrepository.insertUser(
                    UserEntity(
                        id = i,
                        name = "User : Name $i ",
                        phonNumber = "25655555sss5"
                    )
                )
            }

        }

    }
}