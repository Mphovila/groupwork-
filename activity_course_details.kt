package com.example.empoweringthenation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_course_details : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_course_details)
        // Get the course data passed from the previous activity
        val courseName = intent.getStringExtra("courseName")
        val courseDetails = intent.getStringExtra("courseDetails")
        val courseFee = intent.getStringExtra("courseFee")
        val backButton = findViewById<Button>(R.id.backButton2)

        // Set the course data to the TextViews
        findViewById<TextView>(R.id.courseTitle).text = courseName
        findViewById<TextView>(R.id.courseDetails).text = courseDetails
        findViewById<TextView>(R.id.courseFeeTextView).text = "Fee: $courseFee"
        backButton.setOnClickListener {
            finish()  // Return to the previous screen
        }



        }
    }
