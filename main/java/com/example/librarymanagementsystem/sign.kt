package com.example.librarymanagementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class sign : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val d = touch_Demo(this)
        super.onCreate(savedInstanceState)
        setContentView(d)
    }
}