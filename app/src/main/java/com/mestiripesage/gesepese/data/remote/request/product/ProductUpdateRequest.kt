package com.mestiripesage.gesepese.data.remote.request.product

import com.google.gson.annotations.SerializedName
import com.mestiripesage.gesepese.data.entities.Camion
import com.mestiripesage.gesepese.data.entities.Customer
import com.mestiripesage.gesepese.data.entities.Receipt
import java.io.Serializable

class ProductUpdateRequest(
    @SerializedName(value = "name") var name: String,
    @SerializedName(value = "code") var code: String,
    @SerializedName(value = "price") var price: String

) : Serializable