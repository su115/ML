package com.example.ml4.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.ml4.model.Pizza

//package com.example.model;
//import javax.annotation.Generated;
//@Generated("jsonschema2pojo")
class MyJson {
    @SerializedName("People")
    @Expose
    var people: People? = null

    @SerializedName("Pizza")
    @Expose
    var pizza: Pizza? = null
}