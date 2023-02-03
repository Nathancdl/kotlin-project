package com.example.kotlin_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home){

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val layoutInflater = LayoutInflater.from(context)

        // Inflater le layout XML en une vue
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        // Obtenir une référence à la vue container
        val scrollView = rootView.findViewById<ScrollView>(R.id.MainScrollView)

        // Créer un conteneur LinearLayout

        val linearLayout = scrollView.findViewById<LinearLayout>(R.id.scrolllinearlayout)


        val text1 = "Text 1"

        linearLayout.addView(createVisualElement(inflater, linearLayout, text1))
        linearLayout.addView(createVisualElement(inflater, linearLayout, text1))
        linearLayout.addView(createVisualElement(inflater, linearLayout, text1))
        linearLayout.addView(createVisualElement(inflater, linearLayout, text1))
        linearLayout.addView(createVisualElement(inflater, linearLayout, text1))
        linearLayout.addView(createVisualElement(inflater, linearLayout, text1))
        linearLayout.addView(createVisualElement(inflater, linearLayout, text1))


        /*
        scrollView.addView(linearLayout)
        */
        return rootView
    }
    /*
    override fun onStart() {
        super.onStart();
        val view = view;
        //val text = view?.findViewById<TextView>(R.id.hometext)
        //text?.text = "alex"

        val inflater = LayoutInflater.from(context)


        //createVisualElement(layoutInflater.from())
    }*/

    fun createVisualElement(
        inflater: LayoutInflater,
        container: ViewGroup?,
        text: String
    ): View {
        val view = inflater.inflate(R.layout.visual_post, container, false)
        return view
    }
}