package com.example.testroom.core.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testroom.core.basemodols.BaseModel
import com.example.testroom.UserPage.data.entity.UserEntity

@Entity(tableName = "usertb")
data class UserDbModel(
    @PrimaryKey @ColumnInfo(name= "id")  val id:Int,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "phone_number")  val phonNumber:String,
    @ColumnInfo(name = "city")  val city:String,
    @ColumnInfo(name = "bbb")  val bbb:String? =""

): BaseModel<UserDbModel, UserEntity>(){
    override fun converToEntity(): UserEntity {
       return UserEntity(id=this.id,name=this.name,phonNumber=this.phonNumber)
    }

}

