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

class HomeFragmentSearch : Fragment(R.layout.visual_searchuser){

    @SuppressLint("MissingInflatedId")
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

    fun newfollow(uuidUser: String){

    println("newFollow")

    }


}