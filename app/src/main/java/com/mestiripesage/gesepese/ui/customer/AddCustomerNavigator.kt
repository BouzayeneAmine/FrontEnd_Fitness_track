package com.mestiripesage.gesepese.ui.customer

import com.mestiripesage.gesepese.data.entities.Camion
import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.entities.Receipt

interface AddCustomerNavigator {
    fun add(name:String,code:String,adresse:String,products:List<Product>,reciepts:List<Receipt>,camions:List<Camion>)
}