package com.example.ml4.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

//package com.example.model;
//import javax.annotation.Generated;
//@Generated("jsonschema2pojo")
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