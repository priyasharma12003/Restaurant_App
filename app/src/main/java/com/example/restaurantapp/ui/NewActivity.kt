package com.example.restaurantapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurantapp.R
import kotlinx.android.synthetic.main.activity_new.*

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val fruitsData = intent
        val fruitsName = fruitsData.getStringExtra("fruitsName")
        val fruitsInfo = fruitsData.getStringExtra("fruitsInfo")
        val fruitsImg = fruitsData.getIntExtra("fruitsImg",0)
        imgF.setImageResource(fruitsImg)
        foodName.text = fruitsName
        foodInfo.text = fruitsInfo


    }
    }
