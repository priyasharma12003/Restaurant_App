package com.example.restaurantapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantapp.databinding.ActivitySignupScreenBinding
import com.example.restaurantapp.db.AppDatabase
import com.example.restaurantapp.db.User
import com.example.restaurantapp.db.UserDao
import com.example.restaurantapp.viewmodel.ViewModelClass
import com.example.restaurantapp.viewmodel.factory.ViewModelFactoryClass

class SignupScreen: AppCompatActivity() {
    lateinit var binding: ActivitySignupScreenBinding
    lateinit var database: UserDao
    var context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        database = AppDatabase.getInstance(this).userDao()
        val viewmodel =
            ViewModelProvider(this, ViewModelFactoryClass(database)).get(ViewModelClass::class.java)


        binding.signupbtn.setOnClickListener {
            val ob = User()
            ob.email = binding.email.text.toString()
            ob.password = binding.password.text.toString()
            viewmodel.insertUser(ob, database, context)


        }


        binding.textview3.setOnClickListener{
            val intent= Intent(this, LoginScreen::class.java)
            startActivity(intent)
        }
    }
}