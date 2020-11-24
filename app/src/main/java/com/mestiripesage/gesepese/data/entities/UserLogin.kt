package com.mestiripesage.gesepese.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class UserLogin {
    @SerializedName("user")
    @Expose
    var user: User? = null

    @SerializedName("accesstoken")
    @Expose
    var accesstoken: String? = null

    @SerializedName("refreshtoken")
    @Expose
    var refreshtoken: String? = null


}