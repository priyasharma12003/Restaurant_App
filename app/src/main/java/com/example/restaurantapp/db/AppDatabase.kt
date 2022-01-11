package com.example.restaurantapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class,UserAdd::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {


    abstract fun userDao(): UserDao


    companion object{

        @Volatile
        private var INSTANCE: AppDatabase?=null
        fun getInstance(context: Context): AppDatabase {

            synchronized(this){

                var instance: AppDatabase?= INSTANCE
                if (instance==null){

                    instance= Room.databaseBuilder(
                        context.applicationContext, AppDatabase::class.java,
                        "App_Database"
                    ).build()

                }
                return instance
            }
        }
    }
}