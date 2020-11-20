package com.mestiripesage.gesepese.data.remote.request.customer

import com.google.gson.annotations.SerializedName
import com.mestiripesage.gesepese.data.entities.Camion
import com.mestiripesage.gesepese.data.entities.Product
import com.mestiripesage.gesepese.data.entities.Receipt
import java.io.Serializable

class CustomerAddRequest (
    @SerializedName("name") var name: String,
    @SerializedName("code") var code: String,
    @SerializedName("adresse") var adresse: String,
    @SerializedName("camions") var camions:List<Camion>,
    @SerializedName("reciepts") var recipets:List<Receipt>,
    @SerializedName("products") var products:List<Product>
) :Serializable