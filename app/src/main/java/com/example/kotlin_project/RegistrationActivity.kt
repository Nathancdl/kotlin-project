package com.example.kotlin_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.util.*
import java.security.MessageDigest

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

        //Go to login page
        this.findViewById<Button>(R.id.button_connectioninregister).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        //Register Button
        this.findViewById<Button>(R.id.buttonregister).setOnClickListener{
                VerifForm()
        }

    }

    private fun VerifForm(){
        var inputEmail : EditText = this.findViewById<EditText>(R.id.edittextemail)
        //https://stackoverflow.com/questions/10028211/how-can-i-get-the-date-from-the-edittext-and-then-store-it-in-database-in-androi
        var inputbirth : EditText = this.findViewById<EditText>(R.id.edittextebirth)
        // String text = mySpinner.getSelectedItem().toString();
        var inputgenre : Spinner = this.findViewById<Spinner>(R.id.spinnergenre)
        var inputdescription: EditText = this.findViewById<EditText>(R.id.edittextdescription)
        var inputusername : EditText = this.findViewById<EditText>(R.id.edittextusername)
        var inputpassword : EditText = this.findViewById<EditText>(R.id.edittextpassword)
        var inputconfirmpassword : EditText = this.findViewById<EditText>(R.id.edittextconfirmpassword)

        if(inputdescription.text.isEmpty() || inputEmail.text.isEmpty() || inputbirth.text.isEmpty() ||
            inputusername.text.isEmpty() || inputpassword.text.isEmpty() || inputconfirmpassword.text.isEmpty() ){
            DisplayAlertDialog("Formulaire incomplet", "Des champs sont vides")
        }else{

            //Verif email

            if(!isEmailValid(inputEmail.text.toString())){
                DisplayAlertDialog("Email Invalide", "L'email fourni est invalide")
            }else{

                val db = FirebaseFirestore.getInstance()
                val utilisateursRef = db.collection("Utilisateurs")

                if(inputpassword.text.toString() != inputconfirmpassword.text.toString()){

                    DisplayAlertDialog("Mot de passe incorrect", "Les deux mots de passe fournie ne sont pas identiques")

                }else{

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(inputEmail.text.toString().lowercase(), inputpassword.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // L'utilisateur a été inscrit avec succès
                            val uuid = FirebaseAuth.getInstance().currentUser?.uid
                            if (uuid != null) {
                                // On crée un nouvel utilisateur dans la base de données
                                val nouvelUtilisateur = hashMapOf(
                                    "username" to inputusername.text.toString(),
                                    "email" to inputEmail.text.toString().lowercase(),
                                    "genre" to inputgenre.selectedItem.toString(),
                                    "description" to inputdescription.text.toString(),
                                    "datedenaissance" to inputbirth.text.toString(),
                                    "uuid" to uuid,
                                    "publication" to null
                                )
                                val database = Firebase.database.reference

                                val path = "Utilisateurs/" + uuid

                                database.child(path).setValue(nouvelUtilisateur)

                                val intent = Intent(this, MainScreen::class.java)
                                startActivity(intent)

                            }
                        } else {

                            DisplayAlertDialog("Erreur lors de l'inscription", task.exception?.message.toString())
                        }
                    }

                }



            }

        }


    }

    fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex("^([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})$")
        return emailRegex.matches(email)
    }


    private fun DisplayAlertDialog(title : String, message: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which -> null }
        builder.show()
    }
}