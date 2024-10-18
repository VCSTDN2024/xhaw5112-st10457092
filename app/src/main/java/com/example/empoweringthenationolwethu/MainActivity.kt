package com.example.empoweringthenationolwethu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exitButton = findViewById<Button>(R.id.exitButton)
        val proceedButton = findViewById<Button>(R.id.proceedButton)

        exitButton.setOnClickListener {
            finish()
        }

        proceedButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
