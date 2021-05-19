package com.example.ml5.Server

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//import javax.annotation.Generated;
//@Generated("jsonschema2pojo")
class LPizza {
    @SerializedName("Pizzas")
    @Expose
    var pizzas: List<Pizza>? = null
}