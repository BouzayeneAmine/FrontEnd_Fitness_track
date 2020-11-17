package com.mestiripesage.gesepese.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Receipt {


    @SerializedName("_id")
    @Expose
    var id: String? = null

    @SerializedName("numero")
    @Expose
    var numero: String? = null

    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("heure")
    @Expose
    var heure: String? = null

    @SerializedName("weight")
    @Expose
    var weight: String? = null

    @SerializedName("customer")
    @Expose
    var customer: String? = null

    @SerializedName("camion")
    @Expose
    var camion: String? = null

    @SerializedName("product")
    @Expose
    var product: String? = null

    @SerializedName("__v")
    @Expose
    var v: Int? = null

}