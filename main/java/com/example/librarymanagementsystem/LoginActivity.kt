package com.example.librarymanagementsystem

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    lateinit var usernameEditText : TextView
    lateinit var passwordEditText : TextView
    lateinit var save: Button
    lateinit var sharedPreferences: SharedPreferences
    val Email="emailKey"
    val Pass="passKey"
    val myfile = "myprefile"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        save=findViewById(R.id.save)
        sharedPreferences=getSharedPreferences(myfile, Context.MODE_PRIVATE)
        usernameEditText = findViewById(R.id.username_edittext)
        passwordEditText = findViewById(R.id.password_edittext)
        val loginButton = findViewById<Button>(R.id.login_button)
        val signupTextView = findViewById<TextView>(R.id.signup_textview)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val savedCredentials = InternalStorageHelper.getLoginCredentials(this)
            if (savedCredentials.first == username && savedCredentials.second == password) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, NavigationDrawerExample::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        signupTextView.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
    fun save(v: View){
        val e=usernameEditText.text.toString()
        val p=passwordEditText.text.toString()

        val editor=sharedPreferences.edit()

        editor.putString(Email,e)
        editor.putString(Pass,p)

        editor.apply()
    }

    fun clear(v: View){

        usernameEditText.text=""
        passwordEditText.text=""

    }
    fun get(v: View){
        sharedPreferences=getSharedPreferences(myfile, Context.MODE_PRIVATE)

        usernameEditText.text=sharedPreferences.getString(Email,"")
        passwordEditText.text = sharedPreferences.getString(Pass,"")

    }
}