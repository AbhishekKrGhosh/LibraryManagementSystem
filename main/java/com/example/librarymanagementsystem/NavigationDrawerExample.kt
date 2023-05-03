package com.example.librarymanagementsystem


import android.content.Intent
import android.os.Bundle

import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity

import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

import com.google.android.material.navigation.NavigationView


class NavigationDrawerExample : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener{
   lateinit var  drawer: DrawerLayout
   lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer_example)
        var toolbar:Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        var actionBarDrawerToggle = ActionBarDrawerToggle(this,drawer,toolbar,
            R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LibraryFrag()).commit()
            navigationView.setCheckedItem(R.id.nav_library)

        }

    }
    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
        R.id.nav_library -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,LibraryFrag())
                .commit()
        R.id.nav_profile -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,ProfileFrag())
                .commit()
        R.id.nav_issued -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,BookIssued())
            .commit()
        R.id.nav_wishlist -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,Wishlist())
            .commit()

        R.id.nav_share -> Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()

    }
        if(item.itemId == R.id.nav_logout){

            val intent = Intent(this@NavigationDrawerExample, LoginActivity::class.java)
            finish()
            startActivity(intent)
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show()
            return true
        }

        if(item.itemId == R.id.nav_share){

            val share = Intent(Intent.ACTION_SEND)
            share.type = "text/plain"
            share.putExtra(Intent.EXTRA_TEXT, "https://tinyurl.com/LMSinAndroid")
            startActivity(Intent.createChooser(share, " Download this "))
        }
        if(item.itemId == R.id.nav_report){

            val intent = Intent(this@NavigationDrawerExample, RateUs::class.java)
            finish()
            startActivity(intent)

            return true
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }


}