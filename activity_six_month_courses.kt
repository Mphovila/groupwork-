package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_six_month_courses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_six_month_courses)
        // List of course names
        val courses = listOf("First Aid", "Sewing", "Landscaping", "Life Skills")

        // Course details (description and fee) stored in a Map
        val courseDetails = mapOf(
            "First Aid" to Pair("Learn how to handle emergencies such as wounds, burns, fractures, and CPR.", "R1500"),
            "Sewing" to Pair("Master various sewing techniques, stitches, machine threading, and more.", "R1500"),
            "Landscaping" to Pair("Explore garden design, soil care, plant maintenance, and much more.", "R1500"),
            "Life Skills" to Pair("Develop essential skills like communication, time management, and conflict resolution.", "R1500")
        )

        // Set up the ListView with course names
        val listView = findViewById<ListView>(R.id.sixMonthCoursesList)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, courses)
        listView.adapter = adapter

        // Set up the onItemClickListener to pass course details when a course is clicked
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedCourse = courses[position]
            val intent = Intent(this, activity_course_details::class.java)

            // Put course name, description, and fee in the intent
            intent.putExtra("courseName", selectedCourse)
            intent.putExtra("courseDetails", courseDetails[selectedCourse]?.first) // Description
            intent.putExtra("courseFee", courseDetails[selectedCourse]?.second)    // Fee

            // Start the Course Details Activity
            startActivity(intent)
        }

        // Back button to return to the previous screen
        val backButton = findViewById<Button>(R.id.backButton2)
        backButton.setOnClickListener {
            finish()  // Return to the previous screen
        }
    }
}