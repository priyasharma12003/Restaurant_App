package com.example.restaurantapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.FoodData
import com.example.restaurantapp.R

class Expandable(val context: Context, val foodlist:ArrayList<FoodData>) : RecyclerView.Adapter<Expandable.ViewHolderclss>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderclss {
        val view= LayoutInflater.from(context).inflate(R.layout.itemlistlayout,parent,false)
        return ViewHolderclss(view)
    }

    override fun onBindViewHolder(holder: ViewHolderclss, position: Int) {
        val ob=foodlist.get(position)
        holder.imageview.setImageResource(ob.foodImg)

    }

    override fun getItemCount(): Int {
        return foodlist.size
    }


    class ViewHolderclss(view: View) : RecyclerView.ViewHolder(view)
    {
        val imageview=view.findViewById<ImageView>(R.id.foodImg)

    }
}