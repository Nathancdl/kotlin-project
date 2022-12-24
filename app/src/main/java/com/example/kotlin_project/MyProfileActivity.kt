package com.example.kotlin_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_project.databinding.MyprofileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener



class MyProfileActivity : AppCompatActivity()  {
    private lateinit var binding1 : MyprofileBinding
    private lateinit var firebaseAuth : FirebaseAuth


    override fun  onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding1 = MyprofileBinding.inflate(layoutInflater)
        setContentView(R.layout.myprofile)

        firebaseAuth = FirebaseAuth.getInstance()
        //handleloadUserInfo()

        //handle click, go back
        // binding.retour.setOnClickListener(){
            //onBackPressed()
            //}

        //handle click, go edit menu 24,22
        //binding.setting.setOnClickListener(){


            //}



        //handlebinding.registration.setOnClickListener(){


        //handle }
    }

    private fun loadUserInfo(){
        //Reference pour charger informations d'utilisateurs
        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(firebaseAuth.uid!!)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val email = "${snapshot.child("email").value}"
                    val name = "${snapshot.child("name").value}"
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
    }
}