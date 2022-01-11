package com.example.restaurantapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.DataModel
import com.example.restaurantapp.databinding.ItemlistlayoutBinding

class FanLayoutRecycler(val context: Context, val list:ArrayList<DataModel>) : RecyclerView.Adapter<FanLayoutRecycler.ViewHolderclss>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderclss {
       val binding=ItemlistlayoutBinding.inflate(LayoutInflater.from(context))
            return ViewHolderclss(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderclss, position: Int) {
        val ob=list.get(position)
        holder.bind(ob)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolderclss(val view: ItemlistlayoutBinding) : RecyclerView.ViewHolder(view.root)
    {

        fun bind(item : DataModel)
       {
            //view.item=item


        }



    }
}