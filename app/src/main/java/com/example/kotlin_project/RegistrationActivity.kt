package com.example.kotlin_project

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Define content spinner
        var spinnergenre : Spinner = this.findViewById<Spinner>(R.id.spinnergenre)

        ArrayAdapter.createFromResource(
            this,
            R.array.array_genre,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnergenre.adapter = adapter
        }


        //Back to the main page
        this.findViewById<ImageButton>(R.id.buttonbackregister).setOnClickListener {
            startActivity(Intent(this, ConnectionLoginActivity::class.java))
        }

        //Register Button
        this.findViewById<Button>(R.id.buttonregister).setOnClickListener{
                VerifForm()
        }

    }

    private fun VerifForm(){
        var inputFullName : EditText = this.findViewById<EditText>(R.id.edittextfullname)
        var inputEmail : EditText = this.findViewById<EditText>(R.id.edittextemail)
        //https://stackoverflow.com/questions/10028211/how-can-i-get-the-date-from-the-edittext-and-then-store-it-in-database-in-androi
        var inputbirth : EditText = this.findViewById<EditText>(R.id.edittextebirth)
        // String text = mySpinner.getSelectedItem().toString();
        var inputgenre : Spinner = this.findViewById<Spinner>(R.id.spinnergenre)
        var inputusername : EditText = this.findViewById<EditText>(R.id.edittextusername)
        var inputpassword : EditText = this.findViewById<EditText>(R.id.edittextpassword)
        var inputconfirmpassword : EditText = this.findViewById<EditText>(R.id.edittextconfirmpassword)

        if(inputFullName.text.isEmpty() || inputEmail.text.isEmpty() || inputbirth.text.isEmpty() ||
            inputusername.text.isEmpty() || inputpassword.text.isEmpty() || inputconfirmpassword.text.isEmpty() ){
            println("Input Empty")
            DisplayAlertDialog("Formulaire incomplet", "Des champs sont vides")
        }

        println("Test Verif")

    }

    private fun DisplayAlertDialog(title : String, message: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which -> null }

        builder.show()

    }
}