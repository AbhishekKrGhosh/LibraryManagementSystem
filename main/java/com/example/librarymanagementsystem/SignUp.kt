package com.example.librarymanagementsystem

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val nameEditText = findViewById<EditText>(R.id.name_edittext)
        val emailEditText = findViewById<EditText>(R.id.email_edittext)
        val usernameEditText = findViewById<EditText>(R.id.username_edittext)
        val passwordEditText = findViewById<EditText>(R.id.password_edittext)
        val signupButton = findViewById<Button>(R.id.signup_button)

        signupButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (name.isBlank() || email.isBlank() || username.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                if (InternalStorageHelper.getUser(this, username) != null) {
                    Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT).show()
                } else {
                    InternalStorageHelper.saveUser(this, name, email, username, password)
                    InternalStorageHelper.saveLoginCredentials(this, username, password)
                    Toast.makeText(this, "Signup successful!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}