package com.mestiripesage.gesepese.data.remote.response

import com.google.gson.annotations.SerializedName

class Data<T> {
    @SerializedName("state")
    var state: String? = null

    @SerializedName("message")
    var message: String? = null

    @SerializedName("data")
    var data: T? = null

}