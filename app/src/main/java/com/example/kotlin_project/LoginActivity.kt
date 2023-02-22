package com.example.kotlin_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.security.MessageDigest

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

    private fun DisplayAlertDialog(title : String, message: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which -> null }
        builder.show()
    }

    fun hashPassword(password: String): String {
        val bytes = password.toByteArray() // Convertit le mot de passe en tableau de bytes
        val md = MessageDigest.getInstance("SHA-256") // Initialise un objet MessageDigest avec l'algorithme SHA-256
        val digest = md.digest(bytes) // Calcule le hachage du tableau de bytes
        return digest.joinToString("") { "%02x".format(it) } // Convertit le tableau de bytes en une chaîne hexadécimale
    }

    fun Login(){

        val auth = FirebaseAuth.getInstance()
        var email = this.findViewById<EditText>(R.id.edittextusernamelogin).text.toString()
        var password = this.findViewById<EditText>(R.id.edittextpasswordlogin).text.toString()

        //login firebase

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // La connexion a réussi
                    val intent = Intent(this, MainScreen::class.java)
                    startActivity(intent)
                } else {
                    // Une erreur s'est produite lors de la connexion
                    DisplayAlertDialog("Email ou mot de passe incorrect", "L\'email ou le mot de passe est incorrect")
                }
            }


    }
}