package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val sixMonthCoursesButton = findViewById<Button>(R.id.sixMonthCoursesButton)
        val sixWeekCoursesButton = findViewById<Button>(R.id.sixWeekCoursesButton)
        val calculateFeesButton = findViewById<Button>(R.id.calculateFeesButton)

        sixMonthCoursesButton.setOnClickListener {
            startActivity(Intent(this, activity_six_month_courses::class.java))
        }

        sixWeekCoursesButton.setOnClickListener {
            startActivity(Intent(this, activity_six_week_courses::class.java))
        }

        calculateFeesButton.setOnClickListener {
            startActivity(Intent(this, activity_calculate_fees::class.java))
        }
    }
}