package com.example.ml4.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Pizza_1 {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("price")
    @Expose
    var price: Int? = null
}