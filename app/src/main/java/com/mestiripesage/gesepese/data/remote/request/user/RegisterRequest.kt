package com.mestiripesage.gesepese.data.remote.request.user

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RegisterRequest (
    @SerializedName("firstName") var firstname: String,
    @SerializedName ("lastName")var lastname: String,
    @SerializedName("email") var email: String ,
    @SerializedName ("phone")var phone: String ,
    @SerializedName("password") var password:String):Serializable
