package com.mestiripesage.gesepese.data.remote.request.camion

import com.google.gson.annotations.SerializedName

class CamionUpdateRequest (
    @SerializedName("immatricule") var immatricule: String,
    @SerializedName("code") var code: String,
    @SerializedName("tare") var tare: String
)
