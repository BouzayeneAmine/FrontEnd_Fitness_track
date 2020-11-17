package com.mestiripesage.gesepese.data.remote.request.customer

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CustomerUpdateRequest(
    @SerializedName("name") var name: String,
    @SerializedName("code") var code: String,
    @SerializedName("adresse") var adresse: String

) : Serializable