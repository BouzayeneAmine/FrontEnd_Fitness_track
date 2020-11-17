package com.mestiripesage.gesepese.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Camion {
    @SerializedName("receipt")
    @Expose
    var receipts: List<Receipt>? = null

    @SerializedName("customer")
    @Expose
    var customers: String? = null

    @SerializedName("_id")
    @Expose
    var id: String? = null

    @SerializedName("immatricule")
    @Expose
    var immatricule: String? = null

    @SerializedName("code")
    @Expose
    var code: String? = null

    @SerializedName("tare")
    @Expose
    var tare: String? = null

    @SerializedName("__v")
    @Expose
    var v: Int? = null

}