package com.example.ml5.Server

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//import javax.annotation.Generated;
//@Generated("jsonschema2pojo")
class Pizza {
    @SerializedName("pizza_name")
    @Expose
    var pizzaName: String? = null

    @SerializedName("link_photo")
    @Expose
    var linkPhoto: String? = null

    @SerializedName("price")
    @Expose
    var price: Int? = null

    @SerializedName("diameter")
    @Expose
    var diameter: Int? = null

    @SerializedName("mass")
    @Expose
    var mass: Int? = null
}