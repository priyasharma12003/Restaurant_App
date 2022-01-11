package com.example.restaurantapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.restaurantapp.db.User

@Dao
interface UserDao {

    //for single user insert
      @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend  fun insertUser(user: User)

    //checking user exist or not in our db
    @Query("SELECT * FROM tbl_user WHERE email LIKE :email AND password LIKE :password")
    suspend fun readLoginData(email: String, password: String): User

    //deleting all user from db
    @Query("DELETE FROM tbl_user")
   suspend fun deleteAll()

   @Query("select * from tbl_user")
    fun getUsers() :LiveData<User>

    @Query("select email,password from tbl_user where email like :emailtxt")
    suspend fun checkUser( emailtxt:String) : String

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertUserfood(useradd: UserAdd)



}