package com.example.restaurantapp.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantapp.db.UserDao
import com.example.restaurantapp.viewmodel.ViewModelClass

class ViewModelFactoryClass(val database:UserDao) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelClass(database) as T
    }
}