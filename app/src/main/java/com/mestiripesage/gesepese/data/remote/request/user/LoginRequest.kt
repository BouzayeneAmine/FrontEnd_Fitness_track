package com.mestiripesage.gesepese.data.remote.request.user

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LoginRequest(
    @SerializedName(value = "email") var email:String,
    @SerializedName(value = "password") var password :String

    ) :Serializable
