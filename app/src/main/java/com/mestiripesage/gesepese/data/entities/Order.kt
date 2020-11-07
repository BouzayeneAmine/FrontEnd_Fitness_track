package com.mestiripesage.gesepese.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Order {
    @SerializedName("products")
    @Expose
    var products: List<Product>? = null

    @SerializedName("_id")
    @Expose
    var id: String? = null

    @SerializedName("reference")
    @Expose
    var reference: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("user")
    @Expose
    var user: Any? = null

    @SerializedName("__v")
    @Expose
    var v: Int? = null

}