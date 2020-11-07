package com.mestiripesage.gesepese.ui.products.addProduct

import com.mestiripesage.gesepese.data.entities.Order

interface AddProductNavigator {
    fun add (name: String, quantity:String,description:String,price:String,orders:List<Order>,subCategory:String)
}