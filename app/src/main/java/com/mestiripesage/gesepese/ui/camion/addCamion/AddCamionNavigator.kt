package com.mestiripesage.gesepese.ui.camion.addCamion

import com.mestiripesage.gesepese.data.entities.Customer
import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.entities.Receipt

interface AddCamionNavigator {
    fun add(immatricule: String, code: String, tare: String, customers: String)
    fun setValueSpinner(customers: MutableList<String>)
}