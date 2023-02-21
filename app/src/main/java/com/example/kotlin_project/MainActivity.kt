package com.example.kotlin_project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val firebaseOptions = FirebaseOptions.Builder()
            .setDatabaseUrl("https://kotlin-project-7e1ee-default-rtdb.europe-west1.firebasedatabase.app")
            .setApiKey("AIzaSyAQv0IN0LjdMJgbQRHqHJ3xjHSuBcGsWJE")
            .setApplicationId("1:664910856158:android:6ac75db6a48ac9a8").build()
        val myApp = FirebaseApp.initializeApp(
            applicationContext, firebaseOptions, "MyAppName")

        if (myApp != null) {
            Toast.makeText(this, "Firebase connection successful", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Firebase connection failed", Toast.LENGTH_SHORT).show()
        }

        val intent = Intent(this, MainScreen::class.java)
        //val intent = Intent(this, ConnectionLoginActivity::class.java)
        startActivity(intent)
}

}

