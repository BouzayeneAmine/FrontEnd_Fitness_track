package com.mestiripesage.gesepese.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class Category {
    @SerializedName("subcategories")
    @Expose
    var subcategories: List<String>? = null

    @SerializedName("_id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("__v")
    @Expose
    var v: Int? = null

}