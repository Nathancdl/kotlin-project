package com.example.kotlin_project

import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.kotlin_project.databinding.ActivityMyProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class SettingsFragment : Fragment(R.layout.activity_my_profile) {
    private lateinit var binding: ActivityMyProfileBinding
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)

        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signInWithEmailAndPassword("e.merhrioui@gmail.com","EliasMrh")
        loadUserInfo()
    }

    private fun loadUserInfo(){
        //Reference pour charger informations d'utilisateurs
        val ref = FirebaseDatabase.getInstance().getReference("Users")

        ref.child("C8Xqdiz90932")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    //get profile info
                    val uid = "${snapshot.child("uid").value}"
                    val email = "${snapshot.child("email").value}"
                    val profileImage = "${snapshot.child("profileImage").value}"
                    val pseudo = "${snapshot.child("pseudo").value}"
                    val localisation = "${snapshot.child("localisation").value}"
                    val description = "${snapshot.child("description").value}"
                    val nbFollowers = "${snapshot.child("nbFollowers").value}"
                    val nbFollowing = "${snapshot.child("nbFollowing").value}"
                    val nbPosts = "${snapshot.child("nbPosts").value}"
                    val userType = "${snapshot.child("userType").value}"


                    println(profileImage)
                    println(pseudo)
                    println(localisation)
                    println(description)
                    println(nbFollowers)
                    println(nbFollowing)
                    println(nbPosts)


                    //set data

                    binding.pseudo.text = pseudo
                    binding.localisation.text = localisation
                    binding.description.text = description
                    binding.nbFollowing.text = nbFollowing
                    binding.nbFollowers.text = nbFollowers
                    binding.nbPost.text = nbPosts



                }

                override fun onCancelled(error: DatabaseError) {
                    throw Exception("Erreur lors de la récupération des données Firebase : ${error.message}")
                }

            })
    }

}