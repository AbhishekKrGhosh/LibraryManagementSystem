package com.example.librarymanagementsystem

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import java.io.ByteArrayOutputStream
import java.util.*

class Literature : AppCompatActivity() {
    lateinit var button_date: Button
    lateinit var txtDate: EditText
    private var mYear: Int = 0
    private var mMonth: Int = 0
    private var mDay: Int = 0
    lateinit var wish01:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_literature)

        button_date = findViewById(R.id.ib1)
        txtDate = findViewById(R.id.ET1)
        wish01 = findViewById(R.id.wish01)



        button_date.setOnClickListener {
            val c = Calendar.getInstance()
            mYear = c[Calendar.YEAR]
            mMonth = c[Calendar.MONTH]
            mDay = c[Calendar.DAY_OF_MONTH]



            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth
                    ->
                    txtDate.setText("return date is : \n" +
                        dayOfMonth.toString() + "/0" +
                                (monthOfYear + 1) + "/" + year
                    )
                },
                mYear, mMonth, mDay
            )
            datePickerDialog.show()
        }

        var a = false
        wish01.setOnClickListener {

            if(a===false) {
                Toast.makeText(this, "Wishlisted", Toast.LENGTH_SHORT).show()

                val vectorDrawable = ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.baseline_favorite_24_red,
                    null
                )

                vectorDrawable?.setBounds(
                    0,
                    0,
                    vectorDrawable.intrinsicWidth,
                    vectorDrawable.intrinsicHeight
                )

                wish01.setCompoundDrawables(vectorDrawable, null, null, null)
                a=true

            }
            else{
                val vectorDrawable = ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.baseline_favorite_24_white,
                    null
                )

                vectorDrawable?.setBounds(
                    0,
                    0,
                    vectorDrawable.intrinsicWidth,
                    vectorDrawable.intrinsicHeight
                )

                wish01.setCompoundDrawables(vectorDrawable, null, null, null)
                a=false

            }
        }

        }




}