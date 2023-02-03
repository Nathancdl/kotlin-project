package com.example.kotlin_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.connection_login)

        //setContentView(R.layout.activity_my_profile)

        //setContentView(R.layout.activity_main_screen)
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
}

}