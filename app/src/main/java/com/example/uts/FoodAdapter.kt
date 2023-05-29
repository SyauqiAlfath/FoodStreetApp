package com.example.uts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter (private val context: Context, private val food: List<FoodClass>, val listener: (FoodClass) -> Unit)
    : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){
    class FoodViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val foodimg = view.findViewById<ImageView>(R.id.image)
        val foodname = view.findViewById<TextView>(R.id.food_name)
        val foodprice = view.findViewById<TextView>(R.id.food_price)
        val foodrate = view.findViewById<TextView>(R.id.food_rating)
        val ratingbar = view.findViewById<RatingBar>(R.id.ratingbar)

        fun bindView(novel: FoodClass, listener: (FoodClass) -> Unit){

            foodimg.setImageResource(novel.foodimg)
            foodname.text = novel.foodname
            foodprice.text = novel.foodprice
            foodrate.text = novel.foodrate
            ratingbar.rating = novel.ratingbar.toFloat()
            itemView.setOnClickListener{
                (listener(novel))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bindView(food[position], listener)
    }

    override fun getItemCount(): Int = food.size

}