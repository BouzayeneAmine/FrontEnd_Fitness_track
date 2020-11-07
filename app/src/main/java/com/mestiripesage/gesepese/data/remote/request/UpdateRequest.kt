package com.mestiripesage.gesepese.data.remote.request

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class UpdateRequest (
    @SerializedName("firstname") var firstname: String,
    @SerializedName("lastname")var lastname: String,
    @SerializedName("email") var email: String,
    @SerializedName("phone")var phone: String,
    @SerializedName("password") var password:String): Serializable

