package com.example.kotlin_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment


class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val homeFragment = HomeFragment()
        val newPostFragment = NewPostFragment()
        val settingsFragment = SettingsFragment()

        setCurrentFragment(homeFragment)

        val bottomNavigationView = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.mihome -> setCurrentFragment(homeFragment)
                R.id.minewpost -> setCurrentFragment(newPostFragment)
                R.id.misetting -> setCurrentFragment(settingsFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.flFragment, fragment)
        commit()
    }
}