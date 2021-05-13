package com.example.ml4.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Pizza {
    @SerializedName("People")
    @Expose
    var people: People? = null

    @SerializedName("Pizza")
    @Expose
    var pizza: Pizza_1? = null
}