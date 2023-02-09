package com.example.testroom.UserPage.data.entity

import com.example.testroom.core.database.UserDbModel
import java.io.Serializable

data class UserEntity (
      val id:Int,
     val name:String,
     val phonNumber:String
):Serializable{
    fun convertToModelDb(): UserDbModel {
        return UserDbModel(name = this.name, id = this.id, phonNumber = this.phonNumber, bbb = "", city = "")
    }
}