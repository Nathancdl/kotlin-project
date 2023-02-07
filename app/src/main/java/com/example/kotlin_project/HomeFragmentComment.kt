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

class HomeFragmentComment : Fragment(R.layout.visual_post_comment){

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val rootView = inflater.inflate(R.layout.visual_post_comment, container, false)

        rootView.findViewById<ImageButton>(R.id.buttonback).setOnClickListener{
            // Revient sur la page d'avant
            val fragmentManager = fragmentManager
            fragmentManager?.popBackStack()
        }


        rootView.findViewById<Button>(R.id.buttonaddnewcomment).setOnClickListener{
            val fragmentManager = fragmentManager
            val fragmentTransaction = fragmentManager?.beginTransaction()
            val newFragment = HomeFragmentCommentAdd()
            fragmentTransaction?.replace(R.id.frame_comment, newFragment)
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }

        val linearLayout : LinearLayout = rootView.findViewById<LinearLayout>(R.id.commentlayout)

        linearLayout.addView(createComment(inflater, container, "Alex","text comment"))

        return rootView
    }


    fun createComment(
        inflater: LayoutInflater,
        container: ViewGroup?,
        NameUser: String,
        TextContent: String
    ) : View {
        val view : View = inflater.inflate(R.layout.visual_post_one_comment, container, false)
        view.findViewById<TextView>(R.id.nameusercomment).text = NameUser
        view.findViewById<TextView>(R.id.commentcontent).text = TextContent
        return view
    }


}