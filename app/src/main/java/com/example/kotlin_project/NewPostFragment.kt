package com.example.kotlin_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.fragment.app.Fragment

class NewPostFragment : Fragment(R.layout.fragment_newpost){
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val rootView = inflater.inflate(R.layout.fragment_newpost, container, false)

        val button_submit : Button = rootView.findViewById<Button>(R.id.newpostsubmit)

        button_submit.setOnClickListener{
            this.SubmitPost()
        }

        return rootView
    }

    private fun SubmitPost() {
        // Here for submit post data
    }
}