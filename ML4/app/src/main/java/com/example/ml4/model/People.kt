package com.example.ml4.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class People {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("s_name")
    @Expose
    private var sName: String? = null

    @SerializedName("address")
    @Expose
    var address: String? = null

    @SerializedName("phone")
    @Expose
    var phone: Int? = null
    fun getsName(): String? {
        return sName
    }

    fun setsName(sName: String?) {
        this.sName = sName
    }
}