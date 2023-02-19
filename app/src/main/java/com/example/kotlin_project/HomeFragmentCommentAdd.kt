package com.example.kotlin_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment

class HomeFragmentCommentAdd : Fragment(R.layout.visual_post_comment_new){

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val rootView = inflater.inflate(R.layout.visual_post_comment_new, container, false)


        rootView.findViewById<ImageButton>(R.id.buttonbacknewcomment).setOnClickListener{
            val fragmentManager = fragmentManager
            fragmentManager?.popBackStack()
        }

        rootView.findViewById<Button>(R.id.buttonaddcomment).setOnClickListener{
            val contentText : String = rootView.findViewById<EditText>(R.id.edittextusernamelogin).text.toString()
            //envoie vers firebase et revient à la page précédente

        }

        return rootView
    }



}