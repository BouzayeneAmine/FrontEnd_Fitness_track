package com.mestiripesage.gesepese.data.remote.request.reciept

import com.google.gson.annotations.SerializedName
import com.mestiripesage.gesepese.data.entities.Camion
import com.mestiripesage.gesepese.data.entities.Customer
import com.mestiripesage.gesepese.data.entities.Product
import java.io.Serializable

class RecieptAddRequest (
    @SerializedName(value = "numero") var numero: String,
    @SerializedName(value = "date") var date: String,
    @SerializedName(value = "heure") var heure: String,
    @SerializedName(value = "weight") var weight:String,
    @SerializedName(value = "customer") var customer: Customer,
    @SerializedName(value = "Camion") var Camion: Camion,
    @SerializedName(value = "Product") var Product: Product


    ) : Serializable