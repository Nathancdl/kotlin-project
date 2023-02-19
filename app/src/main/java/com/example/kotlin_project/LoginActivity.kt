package com.example.kotlin_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //Back to the main page
        this.findViewById<ImageButton>(R.id.buttonbacklogin).setOnClickListener{
            startActivity(Intent(this, ConnectionLoginActivity::class.java))
        }

        //Go to register page
        this.findViewById<Button>(R.id.button_registerlogin).setOnClickListener{
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        //Login Button
        this.findViewById<Button>(R.id.buttonlogin).setOnClickListener{
            Login()
        }

    }

    fun Login(){

        var username = this.findViewById<EditText>(R.id.edittextusernamelogin).text.toString()
        var password = this.findViewById<EditText>(R.id.edittextpasswordlogin).text.toString()

        //login firebase
    }
}