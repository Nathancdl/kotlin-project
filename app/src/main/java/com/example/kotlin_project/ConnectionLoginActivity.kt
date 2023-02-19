package com.example.kotlin_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ConnectionLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.connection_login)
        this.findViewById<Button>(R.id.registrationbutton).setOnClickListener {
            // Open Activity Register after click button
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
        this.findViewById<Button>(R.id.button_connection).setOnClickListener {
            // Open Activity Login after click button
            startActivity(Intent(this, LoginActivity::class.java))
        }



    }
}