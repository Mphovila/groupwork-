package com.example.empoweringthenation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_calculate_fees : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculate_fees)
        // Six-month courses checkboxes
        val firstAidCheckbox = findViewById<CheckBox>(R.id.firstAidCheckbox)
        val sewingCheckbox = findViewById<CheckBox>(R.id.sewingCheckbox)
        val landscapingCheckbox = findViewById<CheckBox>(R.id.landscapingCheckbox)
        val lifeSkillsCheckbox = findViewById<CheckBox>(R.id.lifeSkillsCheckbox)

        // Six-week courses checkboxes
        val childMindCheckbox = findViewById<CheckBox>(R.id.childMindingCheckbox)
        val cookingCheck = findViewById<CheckBox>(R.id.cookingCheckbox)
        val gardenCheckBox = findViewById<CheckBox>(R.id.gardenMaintenanceCheckbox)

        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val totalCostText = findViewById<TextView>(R.id.totalCostText)
        val backButton = findViewById<Button>(R.id.backButton)

        // Fees for courses
        val sixMonthCourseFee = 1500  // Fee for six-month courses
        val sixWeekCourseFee = 750  // Fee for six-week courses

        calculateButton.setOnClickListener {
            var selectedCourses = 0
            var totalCost = 0

            // Calculate for six-month courses (R1500 each)
            if (firstAidCheckbox.isChecked) {
                selectedCourses++
                totalCost += sixMonthCourseFee
            }
            if (sewingCheckbox.isChecked) {
                selectedCourses++
                totalCost += sixMonthCourseFee
            }
            if (landscapingCheckbox.isChecked) {
                selectedCourses++
                totalCost += sixMonthCourseFee
            }
            if (lifeSkillsCheckbox.isChecked) {
                selectedCourses++
                totalCost += sixMonthCourseFee
            }

            // Calculate for six-week courses (R750 each)
            if (childMindCheckbox.isChecked) {
                selectedCourses++
                totalCost += sixWeekCourseFee
            }
            if (cookingCheck.isChecked) {
                selectedCourses++
                totalCost += sixWeekCourseFee
            }
            if (gardenCheckBox.isChecked) {
                selectedCourses++
                totalCost += sixWeekCourseFee
            }

            // Calculate discount based on the number of selected courses
            val discount = when (selectedCourses) {
                2 -> 0.05  // 5% discount for two courses
                3 -> 0.10  // 10% discount for three courses
                in 4..Int.MAX_VALUE -> 0.15  // 15% discount for more than three courses
                else -> 0.0  // No discount for one course
            }

            // Apply discount to total cost
            val discountedTotal = totalCost * (1 - discount)
            totalCostText.text = "Total: R${discountedTotal.toInt()}"
        }

        backButton.setOnClickListener {
            finish()  // Return to the previous screen
        }
    }
}