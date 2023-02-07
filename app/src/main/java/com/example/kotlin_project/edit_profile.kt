package com.example.kotlin_project

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class edit_profile : Fragment(R.layout.activity_edit_profile) {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val rootView = inflater.inflate(R.layout.activity_edit_profile, container, false)

        rootView.findViewById<ImageButton>(R.id.imageButton).setOnClickListener{
            // Revient sur la page d'avant
            val fragmentManager = fragmentManager
            fragmentManager?.popBackStack()
        }



        return rootView
    }

}