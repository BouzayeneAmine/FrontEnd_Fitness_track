package com.mestiripesage.gesepese.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Customer {
    @SerializedName("camion")
    @Expose
    var camions: List<Camion>? = null

    @SerializedName("product")
    @Expose
    var products: List<Product>? = null

    @SerializedName("receipt")
    @Expose
    var receipts: List<Receipt>? = null
    @SerializedName("_id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("code")
    @Expose
    var code: String? = null

    @SerializedName("adresse")
    @Expose
    var adresse: Receipt? = null

    @SerializedName("__v")
    @Expose
    var v: Int? = null

}