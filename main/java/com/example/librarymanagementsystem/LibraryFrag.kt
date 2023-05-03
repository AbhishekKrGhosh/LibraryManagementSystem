package com.example.librarymanagementsystem

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color.RED
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class LibraryFrag: Fragment() {
    lateinit var v: View
    lateinit var b1: Button
    lateinit var b2: Button
    lateinit var b3: Button
    lateinit var b4: Button
    lateinit var b5: Button
    lateinit var b6: Button

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?  ): View? {
        v = inflater.inflate(R.layout.fragment_library,container,false)
        b1 = v.findViewById(R.id.lit)
        b2 = v.findViewById(R.id.mot)
        b3 = v.findViewById(R.id.science)
        b4 = v.findViewById(R.id.maths)
        b5 = v.findViewById(R.id.cse)
        b6 = v.findViewById(R.id.comics)
        b1.setOnClickListener {
            startActivity(Intent(requireContext(), Literature::class.java))
        }
        b2.setOnClickListener {
            startActivity(Intent(requireContext(), Motivational::class.java))
        }
        b3.setOnClickListener {
            startActivity(Intent(requireContext(), Science::class.java))
        }
        b4.setOnClickListener {
            startActivity(Intent(requireContext(), Maths::class.java))
        }
        b5.setOnClickListener {
            startActivity(Intent(requireContext(), ComputerScience::class.java))
        }
        b6.setOnClickListener {
            startActivity(Intent(requireContext(), Comics::class.java))
        }

        return  v

    }
}