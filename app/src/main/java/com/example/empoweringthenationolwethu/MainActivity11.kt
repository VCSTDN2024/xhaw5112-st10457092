package com.example.empoweringthenationolwethu

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity11 : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var cbCourse1: CheckBox
    private lateinit var cbCourse2: CheckBox
    private lateinit var cbCourse3: CheckBox
    private lateinit var cbCourse4: CheckBox
    private lateinit var cbCourse5: CheckBox
    private lateinit var cbCourse6: CheckBox
    private lateinit var cbCourse7: CheckBox
    private lateinit var btnProceed: Button
    private lateinit var btnBack: Button
    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        cbCourse1 = findViewById(R.id.cbCourse1)
        cbCourse2 = findViewById(R.id.cbCourse2)
        cbCourse3 = findViewById(R.id.cbCourse3)
        cbCourse4 = findViewById(R.id.cbCourse4)
        cbCourse5 = findViewById(R.id.cbCourse5)
        cbCourse6 = findViewById(R.id.cbCourse6)
        cbCourse7 = findViewById(R.id.cbCourse7)
        btnProceed = findViewById(R.id.btnProceed)
        btnBack = findViewById(R.id.btnBack)
        btnHome = findViewById(R.id.btnHome)

        btnProceed.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val phone = etPhone.text.toString()

            // Calculate selected courses and total price
            val selectedCourses = ArrayList<String>()
            var totalPrice = 0
            var numberOfCourses = 0

            if (cbCourse1.isChecked) {
                selectedCourses.add("First Aid - R1500")
                totalPrice += 1500
                numberOfCourses++
            }
            if (cbCourse2.isChecked) {
                selectedCourses.add("Sewing - R1500")
                totalPrice += 1500
                numberOfCourses++
            }
            if (cbCourse3.isChecked) {
                selectedCourses.add("Landscaping - R1500")
                totalPrice += 1500
                numberOfCourses++
            }
            if (cbCourse4.isChecked) {
                selectedCourses.add("Life Skills - R1500")
                totalPrice += 1500
                numberOfCourses++
            }
            if (cbCourse5.isChecked) {
                selectedCourses.add("Child Minding - R750")
                totalPrice += 750
                numberOfCourses++
            }
            if (cbCourse6.isChecked) {
                selectedCourses.add("Cooking - R750")
                totalPrice += 750
                numberOfCourses++
            }
            if (cbCourse7.isChecked) {
                selectedCourses.add("Garden Maintenance - R750")
                totalPrice += 750
                numberOfCourses++
            }

            // Calculate VAT
            val vat = totalPrice * 0.15
            val totalPriceWithVAT = totalPrice + vat

            // Determine discount based on the number of courses
            var discountPercentage = 0.0
            if (numberOfCourses >= 6) {
                discountPercentage = 0.20
            } else if (numberOfCourses >= 4) {
                discountPercentage = 0.15
            } else if (numberOfCourses >= 2) {
                discountPercentage = 0.10
            }

            // Calculate total price after discount
            val discountAmount = totalPriceWithVAT * discountPercentage
            val totalPriceWithDiscount = totalPriceWithVAT - discountAmount

            // Pass data to SummaryActivity
            val intent = Intent(this, MainActivity12::class.java)
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("phone", phone)
            intent.putStringArrayListExtra("courses", selectedCourses)
            intent.putExtra("totalPriceWithoutDiscount", totalPriceWithVAT) // Total with VAT but without discount
            intent.putExtra("totalPriceWithDiscount", totalPriceWithDiscount) // Total with VAT and discount
            intent.putExtra("discountPercentage", discountPercentage * 100) // Pass the discount percentage as well
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

