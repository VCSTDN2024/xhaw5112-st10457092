package com.example.empoweringthenationolwethu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        val backButton = findViewById<Button>(R.id.backButton)
        val proceedButton = findViewById<Button>(R.id.proceedButton)

        backButton.setOnClickListener {
            finish()
        }

        proceedButton.setOnClickListener {
            val intent = Intent(this, MainActivity8::class.java)
            startActivity(intent)
        }
    }
}
