package com.example.empoweringthenationolwethu

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity13 : AppCompatActivity() {

    private lateinit var tvCompanyPhone: TextView
    private lateinit var tvCompanyEmail: TextView
    private lateinit var tvCompanyAddress: TextView
    private lateinit var tvCompanyAddress2: TextView
    private lateinit var tvCompanyAddress3: TextView
    private lateinit var tvViewLocation: TextView
    private lateinit var tvViewLocation2: TextView
    private lateinit var tvViewLocation3: TextView
    private lateinit var btnBack: Button
    private lateinit var btnExit: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main13)

        tvCompanyPhone = findViewById(R.id.tvCompanyPhone)
        tvCompanyEmail = findViewById(R.id.tvCompanyEmail)
        tvCompanyAddress = findViewById(R.id.tvCompanyAddress)
        tvCompanyAddress2 = findViewById(R.id.tvCompanyAddress2)
        tvCompanyAddress3 = findViewById(R.id.tvCompanyAddress3)
        tvViewLocation = findViewById(R.id.tvViewLocation)
        tvViewLocation2 = findViewById(R.id.tvViewLocation2)
        tvViewLocation3 = findViewById(R.id.tvViewLocation3)
        btnBack = findViewById(R.id.btnBack)
        btnExit = findViewById(R.id.btnExit)

        tvCompanyPhone.text = "Telephone: +27 83 493 6559"
        tvCompanyEmail.text = "Email: PowertheNation@gmail.com"
        tvCompanyAddress.text = "Address: 1315 Wit Road, Johannesburg, South Africa"

        // Location 1: 14 Bonanza street, Johannesburg, South Africa
        tvViewLocation.setOnClickListener {
            val geoUri = Uri.parse("geo:0,0?q=14 Bonanza street, Johannesburg, South Africa")
            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        // Location 2: 1315 Wit Road, Johannesburg, Gauteng, South Africa
        tvViewLocation2.setOnClickListener {
            val geoUri = Uri.parse("geo:0,0?q=1315 Wit Road, Johannesburg, Gauteng, South Africa")
            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        // Location 3: 17 Friesland Crescent, Johannesburg, Gauteng, South Africa
        tvViewLocation3.setOnClickListener {
            val geoUri = Uri.parse("geo:0,0?q=17 Friesland Crescent, Johannesburg, Gauteng, South Africa")
            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        btnBack.setOnClickListener {
            finish()
        }

        btnExit.setOnClickListener {
            finishAffinity()
        }
    }
}
