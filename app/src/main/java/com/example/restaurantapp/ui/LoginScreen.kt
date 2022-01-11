package com.example.restaurantapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantapp.databinding.ActivityLoginScreenBinding
import com.example.restaurantapp.db.AppDatabase
import com.example.restaurantapp.db.User
import com.example.restaurantapp.db.UserDao
import com.example.restaurantapp.viewmodel.ValidationviewModel
import com.example.restaurantapp.viewmodel.ViewModelClass
import com.example.restaurantapp.viewmodel.factory.ViewModelFactoryClass

class LoginScreen : AppCompatActivity() {
   lateinit var binding: ActivityLoginScreenBinding
   lateinit var database:UserDao
    var context=this
    private lateinit var viewModel1:ValidationviewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        database=AppDatabase.getInstance(this).userDao()
        val viewmodel=ViewModelProvider(this, ViewModelFactoryClass(database)).get(ViewModelClass::class.java)


        binding.loginBtn.setOnClickListener {
            val ob=User()
            ob.email=binding.email.text.toString()
            ob.password=binding.password.text.toString()
            viewmodel.checkuser(ob,database,context)


        }
         /*this.viewModel1 = ViewModelProviders.of(this).get(ValidationviewModel::class.java)

         binding.viewModel=viewModel1
//        binding.handler=this*/

        /*viewModel1.getLogInResult().observe(this, Observer { result ->
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        })*/


        viewmodel.getUserDetails().observe(this, Observer {
         if(it==null )
         {
             Log.d("TAG", "empty database")
         }else
                     Log.d("TAG", "onCreate: "+it?.email.toString())
        })







    }

    /*override fun onLogInClicked() {
viewModel1.performValidation()

    }*/
}