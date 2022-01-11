package com.example.restaurantapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.restaurantapp.R
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    private val homeFragment= HomeFragment()
    private val searchFragment= SearchFragment()
    private val accountFragment= AccountFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

replacefragment(homeFragment)

        bottom_nav.setOnItemReselectedListener {
            when (it.itemId)
            {
                R.id.home ->
                    replacefragment(homeFragment)
                R.id.search ->
                    replacefragment(searchFragment)
                R.id.account ->
                    replacefragment(accountFragment)
            }
        }
    }

    private fun replacefragment(fragment: Fragment) {
        if(fragment!== null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame,fragment)
            transaction.commit()
        }
    }
    /*val i = Intent(this, LoginScreen::class.java)
    startActivity(i)

    bottom_nav.setOnNavigationItemReselectedListener {
        when (it.itemId){
            R.id.login-> {
                val i = Intent(this, LoginScreen::class.java)
                startActivity(i)
            }
            R.id.signup->
            {
                val i1=Intent(this, SignupScreen::class.java)
                startActivity(i1)

            }

            R.id.Home->
            {
                val i2=Intent(this, HomeScreen::class.java)
                startActivity(i2)
            }
        }
    }*/






    }
