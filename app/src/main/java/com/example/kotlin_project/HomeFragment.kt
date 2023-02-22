package com.example.kotlin_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore

class HomeFragment : Fragment(R.layout.fragment_home){

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val rootView = inflater.inflate(R.layout.fragment_home, container, false)


        val scrollView = rootView.findViewById<ScrollView>(R.id.MainScrollView)


        val linearLayout = scrollView.findViewById<LinearLayout>(R.id.scrolllinearlayout)

        SetUserName(linearLayout.findViewById<TextView>(R.id.nameuser))

        val searchbar = linearLayout.findViewById<EditText>(R.id.edittextsearchhome)

        searchbar.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                println("Launch")
                val fragmentManager = fragmentManager
                val fragmentTransaction = fragmentManager?.beginTransaction()
                val newFragment = HomeFragmentSearch()
                fragmentTransaction?.replace(R.id.fragment_container, newFragment)
                fragmentTransaction?.addToBackStack(null)
                fragmentTransaction?.commit()
                true
            } else {
                false
            }
        }

        linearLayout.addView(createViewPost( "1",inflater, linearLayout, "username", "content texte", 2, 2))


        /*
        scrollView.addView(linearLayout)
        */
        return rootView
    }




    fun SetUserName(Textview : TextView) {
        //Reference pour charger informations d'utilisateurs
        val ref = FirebaseDatabase.getInstance().getReference("Utilisateurs")
        ref.child(FirebaseAuth.getInstance().currentUser?.uid.toString())
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    //get profile info

                    Textview.text = snapshot.child("username").value.toString()
                }

                override fun onCancelled(error: DatabaseError) {
                    throw Exception("Erreur lors de la récupération des données Firebase : ${error.message}")
                }

            })

    }



    fun createViewPost(
        UserId: String,
        inflater: LayoutInflater,
        container: ViewGroup?,
        NameUserPost: String,
        ContentPost: String,
        LikeNumber : Int,
        CommentNumber : Int
    ): View {
        val view : View = inflater.inflate(R.layout.visual_post, container, false)
        view.findViewById<TextView>(R.id.nameusercomment).text = NameUserPost
        view.findViewById<TextView>(R.id.contentpost).text = ContentPost
        view.findViewById<TextView>(R.id.likenumber).text = LikeNumber.toString()
        view.findViewById<TextView>(R.id.commentnumber).text = CommentNumber.toString()
        view.findViewById<ImageButton>(R.id.imagelike).setOnClickListener{
            addLike(UserId)
            view.findViewById<TextView>(R.id.likenumber).text = (LikeNumber + 1).toString()

        }

        view.findViewById<ImageButton>(R.id.imagecomment).setOnClickListener{
            // Affiche les commentaires
            val fragmentManager = fragmentManager
            val fragmentTransaction = fragmentManager?.beginTransaction()
            val newFragment = HomeFragmentComment()
            fragmentTransaction?.replace(R.id.fragment_container, newFragment)
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }

        return view
    }

    fun addLike(UserId : String){
        //Add like to user
    }
}