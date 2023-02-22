package com.example.kotlin_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.example.kotlin_project.Utilisateur

class HomeFragmentSearch : Fragment(R.layout.visual_searchuser){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val rootView = inflater.inflate(R.layout.visual_searchuser, container, false)

        rootView.findViewById<ImageButton>(R.id.buttonbacksearchtohome).setOnClickListener{
            // Revient sur la page d'avant
            val fragmentManager = fragmentManager
            fragmentManager?.popBackStack()
        }

        val linearLayout : LinearLayout = rootView.findViewById<LinearLayout>(R.id.resultsearchlayout)

        val searchContent = arguments?.getString("search").toString()



/*
        val db = Firebase.firestore

        val currentUserUid : String = FirebaseAuth.getInstance().currentUser?.uid.toString()

        val utilisateursRef = db.collection("Utilisateurs")
            .whereEqualTo("username", searchContent)

        utilisateursRef.get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot) {

                    val utilisateur = document.toObject(Utilisateur::class.java)
                    linearLayout.addView(createuser(inflater, container, utilisateur.username, utilisateur.uuid))
                }
            }

*/



        linearLayout.addView(createuser(inflater, container, "Alex","151"))

        return rootView
    }



    fun createuser(
        inflater: LayoutInflater,
        container: ViewGroup?,
        NameUser: String,
        uuidUser: String
    ) : View {
        val view : View = inflater.inflate(R.layout.visual_user, container, false)
        view.findViewById<TextView>(R.id.user_username).text = NameUser
        view.findViewById<Button>(R.id.user_buttonfollow).setOnClickListener{
            view.findViewById<Button>(R.id.user_buttonfollow).isEnabled = false
            newfollow(uuidUser)
        }
        return view
    }

    fun newfollow( uuidUser: String){

    println("newFollow")

    }

    fun search(search : String){
        println("Recherche Effectuer")
        println(search)


    }

}