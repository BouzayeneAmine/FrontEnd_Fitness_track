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
    private var name: String? = null

    @SerializedName("code")
    @Expose
    private var quantity: String? = null


    @SerializedName("price")
    @Expose
    private var price: String? = null

    @SerializedName("__v")
    @Expose
    private var v: Int? = null


}