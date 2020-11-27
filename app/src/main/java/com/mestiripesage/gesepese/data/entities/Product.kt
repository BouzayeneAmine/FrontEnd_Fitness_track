package com.mestiripesage.gesepese.data.entities

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Product {
    @SerializedName("customer")
    @Expose
    private var customers: List<Customer>? = null

    @SerializedName("receipt")
    @Expose
    private var receipts: List<Receipt>? = null

    @SerializedName("_id")
    @Expose
    private var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("code")
    @Expose
     var quantity: String? = null


    @SerializedName("price")
    @Expose
     var price: String? = null

    @SerializedName("__v")
    @Expose
     var v: Int? = null


}