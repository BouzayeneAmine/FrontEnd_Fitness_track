package com.mestiripesage.gesepese.data.remote.request

import com.google.gson.annotations.SerializedName
import com.mestiripesage.gesepese.data.entities.Order
import java.io.Serializable

class UpdateProductRequest (
    @SerializedName("name") var name: String,
    @SerializedName("quantity")var quantity: String,
    @SerializedName("description") var description: String,
    @SerializedName("price")var price: String,
    @SerializedName("orders") var Order:List<Order>,
    @SerializedName("subCategory") var subcategory:String

):Serializable