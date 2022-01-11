package com.example.restaurantapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class  ValidationviewModel : ViewModel() {

    /**
     * Two way bind-able fields
     */
    var username: String = ""
    var password: String = ""
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    /**
     * To pass login result to activity
     */
    private val logInResult = MutableLiveData<String>()

    fun getLogInResult(): LiveData<String> = logInResult

    /**
     * Called from activity on login button click
     */
    fun performValidation() {

        if (username.isBlank()|| !username.matches(emailPattern.toRegex())) {
            logInResult.value = "Invalid username"
            return
        }

        if (password.isBlank()) {
            logInResult.value = "Invalid password"
            return
        }

        logInResult.value = "Valid credentials :)"
    }

}