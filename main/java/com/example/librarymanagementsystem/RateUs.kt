package com.example.librarymanagementsystem


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast

class RateUs : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_us)
        val ratingBar:RatingBar=findViewById(R.id.rb)
        val feedback=findViewById<TextView>(R.id.feedback)
        val bt=findViewById<Button>(R.id.bt)
        val back = findViewById<Button>(R.id.back)

        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            when (rating.toInt()) {
                0 -> feedback.text = "Very Dissatisfied"
                1 -> feedback.text = "Dissatisfied"
                2, 3 -> feedback.text = "OK"
                4 -> feedback.text = "Satisfied"
                5 -> feedback.text = "Very Satisfied"
                else -> { /* Do nothing */ }
            }
        }
        bt.setOnClickListener {

            val totalStars = "Total Stars:: " + ratingBar.numStars
            val rating = "Rating :: " + ratingBar.rating
            val feedback="Feedback :: "+feedback.text.toString()
            Toast.makeText(this@RateUs, """$totalStars$rating$feedback""".trimIndent(), Toast.LENGTH_LONG).show()

        }
        back.setOnClickListener {
            val intent = Intent(this, NavigationDrawerExample::class.java)
            startActivity(intent)
            finish()
        }
    }
}