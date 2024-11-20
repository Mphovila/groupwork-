package com.example.empoweringthenation

import android.annotation.SuppressLint
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

class activity_six_week_courses : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_six_week_courses)
        // List of course names for six-week courses
        val sixWeekCourses = listOf("Child Minding", "Cooking", "Garden Maintenance")

        // Course details (description and fee) stored in a Map
        val courseDetails = mapOf(
            "Child Minding" to Pair("Learn childcare fundamentals including feeding, bathing, and ensuring safety.", "R750"),
            "Cooking" to Pair("Master essential cooking techniques, from basic recipes to advanced meal prep.", "R750"),
            "Garden Maintenance" to Pair("Learn gardening techniques such as pruning, watering, and plant care.", "R750")
        )

        // Set up the ListView with course names
        val listView = findViewById<ListView>(R.id.sixWeekCoursesList)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sixWeekCourses)
        listView.adapter = adapter

        // Set up the onItemClickListener to pass course details when a course is clicked
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedCourse = sixWeekCourses[position]
            val intent = Intent(this, activity_course_details::class.java)

            // Put course name, description, and fee in the intent
            intent.putExtra("courseName", selectedCourse)
            intent.putExtra("courseDetails", courseDetails[selectedCourse]?.first) // Description
            intent.putExtra("courseFee", courseDetails[selectedCourse]?.second)    // Fee

            // Start the Course Details Activity
            startActivity(intent)
        }

        // Back button to return to the previous screen
        val backButton = findViewById<Button>(R.id.backButton1)
        backButton.setOnClickListener {
            finish()  // Return to the previous screen
        }
    }
}