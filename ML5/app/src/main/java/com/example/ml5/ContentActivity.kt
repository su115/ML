package com.example.ml5

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class ContentActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle? ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choicen_pizza)

        //name
        var pizza_name = findViewById<TextView>(R.id.pizza_name_cc)
        pizza_name.text = intent.getStringExtra("name")

        //price
        var price = findViewById<TextView>(R.id.price_cc)
        price.text = intent.getStringExtra("price")

        //mass
        var mass = findViewById<TextView>(R.id.mass_cc)
        mass.text = intent.getStringExtra("mass")

        //diameter
        var diameter = findViewById<TextView>(R.id.diameter_cc)
        diameter.text = intent.getStringExtra("diameter")

        //link
        var image = findViewById<ImageView>(R.id.pizza_photo_cc)
        Picasso.get().load(intent.getStringExtra("link")).into(image)

    }

}