package com.mestiripesage.gesepese.ui.products.addProduct

import com.mestiripesage.gesepese.data.entities.Camion
import com.mestiripesage.gesepese.data.entities.Customer
import com.mestiripesage.gesepese.data.entities.Receipt

interface AddProductNavigator {
    fun add (name: String, quantity:String, price:String, customers:List<Customer>, receipts:List<Receipt>)
}