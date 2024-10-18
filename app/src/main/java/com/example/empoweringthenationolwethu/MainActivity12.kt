package com.example.empoweringthenationolwethu

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity12 : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvCourses: TextView
    private lateinit var tvTotalPriceWithoutDiscount: TextView
    private lateinit var tvTotalPriceWithDiscount: TextView
    private lateinit var tvDiscountPercentage: TextView
    private lateinit var btnBackToForm: Button
    private lateinit var btnProceedToNext: Button
    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)


        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvPhone = findViewById(R.id.tvPhone)
        tvCourses = findViewById(R.id.tvCourses)
        tvTotalPriceWithoutDiscount = findViewById(R.id.tvTotalPriceWithoutDiscount)
        tvTotalPriceWithDiscount = findViewById(R.id.tvTotalPriceWithDiscount)
        tvDiscountPercentage = findViewById(R.id.tvDiscountPercentage)
        btnBackToForm = findViewById(R.id.btnBackToForm)
        btnProceedToNext = findViewById(R.id.btnProceedToNext)
        btnHome = findViewById(R.id.btnHome)

        // Retrieve values from Intent
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val courses = intent.getStringArrayListExtra("courses")
        val totalPriceWithoutDiscount = intent.getDoubleExtra("totalPriceWithoutDiscount", 0.0)
        val totalPriceWithDiscount = intent.getDoubleExtra("totalPriceWithDiscount", 0.0)
        val discountPercentage = intent.getDoubleExtra("discountPercentage", 0.0)

        // Set text values
        tvName.text = "Name: $name"
        tvEmail.text = "Email: $email"
        tvPhone.text = "Phone: $phone"
        tvCourses.text = "Courses: ${courses?.joinToString(", ")}"
        tvTotalPriceWithoutDiscount.text = "Total Price (without discount): R$totalPriceWithoutDiscount"
        tvTotalPriceWithDiscount.text = "Total Price (with discount): R$totalPriceWithDiscount"
        tvDiscountPercentage.text = "Discount applied: $discountPercentage%"

        // Set button actions
        btnBackToForm.setOnClickListener {
            finish() // Go back to the previous form
        }

        btnProceedToNext.setOnClickListener {
            Toast.makeText(this, "Application form sent to the Organisation", Toast.LENGTH_LONG).show()

            val intent = Intent(this, MainActivity13::class.java)
            startActivity(intent)
        }

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

