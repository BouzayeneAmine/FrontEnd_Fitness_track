package com.mestiripesage.gesepese.data.remote.request

import com.google.gson.annotations.SerializedName
import com.mestiripesage.gesepese.data.entities.Order
import java.io.Serializable
import java.util.ArrayList

class LoginRequest(
    @SerializedName(value = "email") var email:String,
    @SerializedName(value = "password") var password :String

    ) :Serializable
