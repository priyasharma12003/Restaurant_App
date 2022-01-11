package com.example.restaurantapp.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restaurantapp.ui.HomeScreen
import com.example.restaurantapp.db.User
import com.example.restaurantapp.db.UserAdd
import com.example.restaurantapp.db.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelClass(val database: UserDao) : ViewModel() {

    var TAG = "TAG"
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    var username: String = ""
    var password: String = ""
    private val logInResult = MutableLiveData<String>()

    fun getLogInResult(): LiveData<String> = logInResult

    fun insertUser(user: User, database: UserDao, context: Context) {
        CoroutineScope(Dispatchers.IO).launch {

            if (user.email.toString().trim().toLowerCase()
                    .equals(database.checkUser(user.email.toString().toLowerCase().trim()))
            ) {

                context.startActivity(Intent(context, HomeScreen::class.java))

                android.os.Handler(Looper.getMainLooper()).post(Runnable {
                    Toast.makeText(context, "user exist", Toast.LENGTH_LONG).show()

                })


            } else {
                if (user.password.toString().length < 6) {
                    android.os.Handler(Looper.getMainLooper()).post(Runnable {
                        Toast.makeText(context, "invalid password", Toast.LENGTH_LONG).show()
                    })
                } else if (user.email.toString().isEmpty()) {
                    android.os.Handler(Looper.getMainLooper()).post(Runnable {
                        Toast.makeText(context, "email cant be null", Toast.LENGTH_LONG).show()


                    })
                } else if (!user.email.toString().matches(emailPattern.toRegex())) {

                    android.os.Handler(Looper.getMainLooper()).post(Runnable {
                        Toast.makeText(context, "email invalid", Toast.LENGTH_LONG).show()


                    })
                } else if (user.password.toString().isEmpty()) {
                    android.os.Handler(Looper.getMainLooper()).post(Runnable {
                        Toast.makeText(context, "password cant be null", Toast.LENGTH_LONG).show()


                    })

                } else {
                    database.insertUser(user)
                    android.os.Handler(Looper.getMainLooper()).post(Runnable {
                        Toast.makeText(context, "user created", Toast.LENGTH_LONG).show()

                    })


                }// Toast.makeText(applicationContext,"inserted",Toast.LENGTH_LONG).show()


            }
        }
    }
    fun checkuser(user: User, database: UserDao, context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            if (user.email.toString().trim().toLowerCase()
                    .equals(database.checkUser(user.email.toString().toLowerCase().trim()))
            ) {

                context.startActivity(Intent(context, HomeScreen::class.java))
                android.os.Handler(Looper.getMainLooper()).post(Runnable {
                    Toast.makeText(context, "Login Successfull", Toast.LENGTH_LONG).show()

                })
            }
                else
                {
                    android.os.Handler(Looper.getMainLooper()).post(Runnable {
                        Toast.makeText(context, "User doesnot Exist",
                            Toast.LENGTH_LONG).show()

                    })
                }

            fun insertfood(useradd: UserAdd,database1:UserDao,context: Context){
                CoroutineScope(Dispatchers.IO).launch {
                    if(useradd.foodName.toString().trim().isEmpty()  ){
                        android.os.Handler(Looper.getMainLooper()).post(Runnable {
                            Toast.makeText(context, "empty name", Toast.LENGTH_LONG).show()
                        })
                    }
                    else {
                        database.insertUserfood(useradd)

                    }
                }


            }
        }
    }


















 /*   fun performValidation() {

        if (username.isBlank()|| !username.matches(emailPattern.toRegex())) {
            logInResult.value = "Invalid username"
            return
        }

        if (password.isBlank()||password.length<6) {
            logInResult.value = "Invalid password"
            return
        }

        logInResult.value = "Valid credentials :)"
    }*/














    /*fun validate (user: User) : Boolean {

        if (user.email.trim { it <= ' ' }.isEmpty()
            || user.email.trim { it <= ' ' }.length < 6) {

            // I put the value so that the screen has some action
            validationLiveEvent.value = Validations.EmailEmpty
            return false
        }

        if (user.password.trim { it <= ' ' }.isEmpty()) {
            validationLiveEvent.value = Validations.PasswordEmpty
            return false
        }

        return true
    }*/


    /* val data1=MutableLiveData<User>()
    val tempdata:LiveData<User>
    get() = data1
    */
    fun getUserDetails(): LiveData<User> {

        return database.getUsers()
    }
}


