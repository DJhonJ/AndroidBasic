package com.example.androidbasic.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.androidbasic.R
import kotlinx.android.synthetic.main.fragment_sumar.*

class SumarFragment: Fragment() {
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //var numer1 : Int = Integer.parseInt(editTextNumberOne.text.toString())
        //var number2 : Int = Integer.parseInt(editTextNumberTwo.text.toString())

        //buttonFragment.setOnClickListener {
            //textViewResultado.text =  (numer1 + number2).toString()
            //Toast.makeText(context, "Mensaje desde el fragment", Toast.LENGTH_SHORT).show()
        //}

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sumar, container, false)
    }
}