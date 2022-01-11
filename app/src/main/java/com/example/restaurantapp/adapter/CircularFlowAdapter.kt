package com.example.restaurantapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.FoodData
import com.example.restaurantapp.R
import com.example.restaurantapp.databinding.ItemlistlayoutBinding
import com.example.restaurantapp.ui.NewActivity

/*class CircularFlowAdapter(private var c: Context, private val foodList:List<FoodData>): RecyclerView.Adapter<FoodsAdapter.FruitsViewHolder>() {


    inner class FruitsViewHolder(val v: ItemlistlayoutBinding): RecyclerView.ViewHolder(v.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        val infalter = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ItemlistlayoutBinding>(infalter,
            R.layout.circularlayout,parent,false)
        return FruitsViewHolder(v)
    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        val fruitsLists = foodList[position]
        holder.v.isFruitsList = fruitsLists
        holder.v.foodImg.setImageResource(fruitsLists.foodImg)
        holder.v.root.setOnClickListener {
            var imgF :Int= fruitsLists.foodImg
            var foodsIntent = Intent(c, NewActivity::class.java)
            foodsIntent.putExtra("fruitsName",fruitsLists.foodName)
            foodsIntent.putExtra("fruitsInfo",fruitsLists.foodInfo)
            foodsIntent.putExtra("fruitsImg",imgF)
            c.startActivity(foodsIntent)


        }

    }

    override fun getItemCount(): Int {
        return foodList.size
    }

}*/
