package com.example.shoppingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MyCartActivity : AppCompatActivity() {

    private var productPrice = 120
    private var quantity = 2

    private lateinit var tvQuantity: TextView
    private lateinit var tvProductPrice: TextView
    private lateinit var tvSubtotal: TextView
    private lateinit var tvTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        productPrice = intent.getIntExtra("PRODUCT_PRICE", 120)

        tvQuantity = findViewById(R.id.tvQuantity)
        tvProductPrice = findViewById(R.id.tvProductPrice)
        tvSubtotal = findViewById(R.id.tvSubtotal)
        tvTotal = findViewById(R.id.tvTotal)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val btnIncrease = findViewById<ImageButton>(R.id.btnIncrease)
        val btnDecrease = findViewById<ImageButton>(R.id.btnDecrease)
        val btnPlaceOrder = findViewById<Button>(R.id.btnPlaceOrder)

        updateUI()

        btnBack.setOnClickListener {
            finish()
        }

        btnIncrease.setOnClickListener {
            quantity++
            updateUI()
        }

        btnDecrease.setOnClickListener {
            if (quantity > 1) {
                quantity--
                updateUI()
            }
        }

        btnPlaceOrder.setOnClickListener {
            val intent = Intent(this, SuccessfullyPopActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateUI() {
        tvQuantity.text = quantity.toString()
        tvProductPrice.text = "$productPrice$"

        val total = productPrice * quantity
        tvSubtotal.text = "Subtotal ($quantity items)"
        tvTotal.text = "$total $"
    }
}