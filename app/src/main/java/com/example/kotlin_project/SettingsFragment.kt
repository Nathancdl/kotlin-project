package com.example.kotlin_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
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

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?) : View {

        //super.onCreate(savedInstanceState)

        val rootView = inflater.inflate(R.layout.activity_my_profile, container, false)


        rootView.findViewById<Button>(R.id.editprofile).setOnClickListener{

            val fragmentManager = fragmentManager
            val fragmentTransaction = fragmentManager?.beginTransaction()
            val newFragment = edit_profile()
            fragmentTransaction?.replace(R.id.frame_editprofile, newFragment)
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }


        binding = ActivityMyProfileBinding.inflate(layoutInflater)

        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signInWithEmailAndPassword("e.merhrioui@gmail.com","EliasMrh")
        loadUserInfo(rootView)

        return rootView;

    }

    private fun loadUserInfo(rootView : View){
        //Reference pour charger informations d'utilisateurs
        val ref = FirebaseDatabase.getInstance().getReference("Users")

        ref.child("eQZDdsrZhDygfeEZQD")
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
                    val nbPost = "${snapshot.child("nbPosts").value}"
                    val userType = "${snapshot.child("userType").value}"


                    rootView.findViewById<TextView>(R.id.pseudo).text = pseudo
                    rootView.findViewById<TextView>(R.id.localisation).text = localisation
                    rootView.findViewById<TextView>(R.id.description).text = description
                    rootView.findViewById<TextView>(R.id.nbFollowers).text = nbFollowers
                    rootView.findViewById<TextView>(R.id.nbFollowing).text = nbFollowing
                    rootView.findViewById<TextView>(R.id.nbPost).text = nbPost



                }

                override fun onCancelled(error: DatabaseError) {
                    throw Exception("Erreur lors de la récupération des données Firebase : ${error.message}")
                }

            })
    }

}