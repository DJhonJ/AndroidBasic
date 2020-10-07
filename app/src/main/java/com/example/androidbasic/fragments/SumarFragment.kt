package com.example.androidbasic.fragments

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.androidbasic.R
import com.example.androidbasic.`interface`.IClicked
import kotlinx.android.synthetic.main.fragment_sumar.*

class SumarFragment: Fragment() {
    private var resultado: Int = 0
    private var iClicked: IClicked? = null
    private var textViewResultado: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sumar, container, false)
        textViewResultado = view!!.findViewById<TextView>(R.id.textViewResultado)

        val button = view!!.findViewById<Button>(R.id.buttonFragment)

        button!!.setOnClickListener {
            val numberOne: Int = Integer.parseInt(view!!.findViewById<EditText>(R.id.editTextNumberOne).text.toString())
            val numberTwo : Int = Integer.parseInt(view!!.findViewById<EditText>(R.id.editTextNumberTwo).text.toString())

            resultado = sumar(numberOne, numberTwo)
            textViewResultado?.text = resultado.toString()
        }

        //llamamos al evento y se ejecuta desde el mainactivity
        iClicked!!.click(true)

        return view
    }

    // metodo que comunica una actividad con el fragment
    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is Activity)  iClicked = context as IClicked
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("resultado", resultado)
        resultado = resultado
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        var resultado : Int? = savedInstanceState?.getInt("resultado")

        if (resultado != null) {
            textViewResultado?.text = resultado.toString()
        }
    }

    private fun sumar (numberOne: Int, numberTwo: Int) : Int = numberOne + numberTwo
}