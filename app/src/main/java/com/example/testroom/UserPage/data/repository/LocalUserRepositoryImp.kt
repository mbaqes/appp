package com.example.testroom.UserPage.data.repository

import android.annotation.SuppressLint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.testroom.core.Recourc
import com.example.testroom.core.database.UserDb
import com.example.testroom.UserPage.data.entity.UserEntity

class LocalUserRepositoryImps: LocalUserRepository {
  private  var database = UserDb.initDb(null)
     override suspend fun getallUSer(): Flow<Recourc<List<UserEntity>>> {
        return flow {
            emit(Recourc.Loading<List<UserEntity>>())
         var listuser= database.getuserDao().getallUser()
            emit(Recourc.Success<List<UserEntity>>(data = listuser.map { it.converToEntity() }))
        }

    }
    override suspend fun insertUser(user: UserEntity) {
        database.getuserDao().inserUser(user.convertToModelDb())

    }
}