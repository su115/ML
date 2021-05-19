package com.example.ml5

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.ml5.DataBase.Pizza_d
import com.example.ml5.Server.LPizza
import com.example.ml5.Server.Pizza
import com.squareup.picasso.Picasso
import java.io.InputStream
import java.net.URL


class MainPresenter(context: Context, lpizza: LPizza,grabli:Pizza?):RecyclerView.Adapter<MainPresenter.ViewHolder>() {
    var lpizzaR=lpizza
    var contextR=context
    var grabli=grabli

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var pizza_name = view.findViewById<TextView>(R.id.pizza_name_item)
        var price = view.findViewById<TextView>(R.id.price_item)
        var photo = view.findViewById<ImageView>(R.id.photo_pizza_item)

        fun bind(pizza: Pizza, context: Context,grabli: Pizza?){
            pizza_name.text=pizza.pizzaName
            price.text=pizza.price.toString()
            Picasso.get().load(pizza.linkPhoto).into(photo);
            itemView.setOnClickListener(){

                Toast.makeText(context,"IT work",Toast.LENGTH_SHORT).show()
                val i = Intent(context,ContentActivity::class.java).apply {
                    putExtra("name",pizza.pizzaName)
                    putExtra("price",pizza.price.toString())
                    putExtra("link",pizza.linkPhoto)
                    putExtra("diameter",pizza.diameter.toString())
                    putExtra("mass",pizza.mass.toString())
                }
                context.startActivity(i)

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPresenter.ViewHolder {
        var inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: MainPresenter.ViewHolder, position: Int) {
        var pizza = lpizzaR.pizzas?.get(position)
        holder.bind(pizza!!,contextR,grabli)
    }

    override fun getItemCount(): Int {
        return this.lpizzaR.pizzas!!.size
    }
}




