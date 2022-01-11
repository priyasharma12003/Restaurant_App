package com.example.restaurantapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="tbl_useradd")
data class UserAdd(
    @PrimaryKey(autoGenerate = true)
    val id:Long=0,
    @ColumnInfo(name="FoodName")
    var foodName: String?="",
    @ColumnInfo(name="FoodInfo")
    var FoodInfo :String?="",
)
