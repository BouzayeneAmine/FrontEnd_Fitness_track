package com.mestiripesage.gesepese.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Customer {
    @SerializedName("camion")
    @Expose
    var camions: List<Camion>? = null


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
    var adresse: String? = null

    @SerializedName("__v")
    @Expose
    var v: Int? = null

}