package com.example.librarymanagementsystem

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ProfileFrag: Fragment() {
    lateinit var v: View
    lateinit var b: Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?  ): View? {

        v = inflater.inflate(R.layout.fragment_profile,container,false)
        b = v.findViewById(R.id.signhere)
        b.setOnClickListener {
            startActivity(Intent(requireContext(), sign::class.java))
        }
        return  v
    }
}