package com.mestiripesage.gesepese.data.remote.request

import com.google.gson.annotations.SerializedName
import com.mestiripesage.gesepese.data.entities.Order
import java.io.Serializable

class ProductAddRequest(
    @SerializedName(value = "name") var name:String,
    @SerializedName(value = "quantity") var quantity:String,
    @SerializedName(value = "description") var description:String,
    @SerializedName(value = "price") var price:String,
    @SerializedName(value = "orders") var orders:List<Order>? = null,
    @SerializedName(value = "subCategory") var subCategory: String?

) :Serializable