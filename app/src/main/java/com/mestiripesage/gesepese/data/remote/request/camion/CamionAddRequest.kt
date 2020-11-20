package com.mestiripesage.gesepese.data.remote.request.camion

import com.google.gson.annotations.SerializedName
import com.mestiripesage.gesepese.data.entities.Customer
import com.mestiripesage.gesepese.data.entities.Receipt
import java.io.Serializable

class CamionAddRequest(
    @SerializedName("immatricule") var immatricule: String,
    @SerializedName("code") var code: String,
    @SerializedName("tare") var tare: String,
    @SerializedName("customers") var customers:String,
    @SerializedName("Receipt") var receipts: List<Receipt>

) : Serializable