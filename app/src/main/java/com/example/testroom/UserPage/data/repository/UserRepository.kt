package com.example.testroom.UserPage.data.repository

import kotlinx.coroutines.flow.Flow
import com.example.testroom.core.Recourc
import com.example.testroom.UserPage.data.entity.UserEntity

interface LocalUserRepository {
    suspend fun getallUSer(): Flow<Recourc<List<UserEntity>>>
 suspend  fun insertUser(user: UserEntity)

}