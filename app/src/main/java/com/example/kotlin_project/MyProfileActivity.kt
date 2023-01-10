package com.example.kotlin_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.kotlin_project.databinding.ActivityMyProfileBinding

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MyProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyProfileBinding
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_my_profile)

        firebaseAuth = FirebaseAuth.getInstance()
        loadUserInfo()
    }

    private fun loadUserInfo(){
        //Reference pour charger informations d'utilisateurs
        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(firebaseAuth.uid!!)
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

                    //set data
                    binding.pseudo.text = pseudo
                    binding.localisation.text = localisation
                    binding.description.text = description
                    binding.nbFollowing.text = nbFollowing
                    binding.nbFollowers.text = nbFollowers
                    binding.nbPost.text = nbPosts

                    //set photo de profile
                    try {
                        Glide.with(this@MyProfileActivity).load(profileImage)
                            .placeholder(R.drawable.oval_blast_off_bronze)
                            .into(binding.oval4)
                    } catch (e: Exception){

                    }

               }

               override fun onCancelled(error: DatabaseError) {
                   TODO("Not yet implemented")
               }

           })
    }


}