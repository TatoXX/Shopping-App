package com.example.shoppingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ProductActivity : AppCompatActivity() {

    private val productPrice = 120

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val btnAddToCart = findViewById<Button>(R.id.btnAddToCart)
        val btnCart = findViewById<ImageButton>(R.id.btnCart)

        btnAddToCart.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            intent.putExtra("PRODUCT_PRICE", productPrice)
            startActivity(intent)
        }

        btnCart.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            intent.putExtra("PRODUCT_PRICE", productPrice)
            startActivity(intent)
        }
    }
}