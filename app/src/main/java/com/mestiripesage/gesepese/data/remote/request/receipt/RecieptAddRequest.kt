package com.mestiripesage.gesepese.data.remote.request.receipt

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RecieptAddRequest(
    @SerializedName("numero") var numero: String,
    @SerializedName("date") var date: String,
    @SerializedName("heure") var heure: String,
    @SerializedName("weight") var weight: String,
    @SerializedName("customer") var customer: String,
    @SerializedName("camion") var camion: String,
    @SerializedName("product") var product: String
) : Serializable