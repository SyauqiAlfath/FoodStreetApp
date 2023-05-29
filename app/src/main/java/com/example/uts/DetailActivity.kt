package com.example.uts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val recipe = findViewById<Button>(R.id.food_button)
        recipe.setOnClickListener {
            val url = "https://cookpad.com/id/home"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val food = intent.getParcelableExtra<FoodClass>(MainActivity.INTENT_PARCELABLE)

        val foodimg = findViewById<ImageView>(R.id.image)
        val foodname = findViewById<TextView>(R.id.food_name)
        val foodprice = findViewById<TextView>(R.id.food_price)
        val foodrate = findViewById<TextView>(R.id.food_rating)
        val ratingbar = findViewById<RatingBar>(R.id.ratingbar)
        val fooddesc = findViewById<TextView>(R.id.food_description)

        foodimg.setImageResource(food?.foodimg!!)
        foodname.text = food.foodname
        foodprice.text = food.foodprice
        foodrate.text = food.foodrate
        ratingbar.rating = food.ratingbar.toFloat()
        fooddesc.text = food.fooddesc
    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}