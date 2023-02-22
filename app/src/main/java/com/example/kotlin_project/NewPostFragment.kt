package com.example.kotlin_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class NewPostFragment : Fragment(R.layout.fragment_newpost){


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val rootView = inflater.inflate(R.layout.fragment_newpost, container, false)

        val button_submit : Button = rootView.findViewById<Button>(R.id.newpostsubmit)

        button_submit.setOnClickListener{
            this.SubmitPost(rootView.findViewById<EditText>(R.id.edittextusernamelogin))
        }

        return rootView
    }

    private fun SubmitPost(EditText: EditText) {
        // Here for submit post data

        if(EditText.text.toString().length <= 10){
            DisplayAlertDialog("Post Trop court", "Le texte de votre poste est trop court")
        }else{
            val database = Firebase.database.reference

            val path = "Utilisateurs/"+ FirebaseAuth.getInstance().currentUser?.uid.toString() + "/publication/" + UUID.randomUUID().toString()

            val newpost = hashMapOf(
                "content" to EditText.text.toString(),
                "date" to Date().time.toString(),
                "like" to 0,
                "comment" to null
            )

            database.child(path).setValue(newpost)

            DisplayAlertDialog("Nouveau poste", "Votre poste a été publier")

            EditText.text.clear()

        }

    }

    private fun DisplayAlertDialog(title : String, message: String){
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which -> null }
        builder.show()
    }
}