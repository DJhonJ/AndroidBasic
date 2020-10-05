package com.example.androidbasic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.androidbasic.fragments.GreenFragment
import com.example.androidbasic.fragments.OneFragment
import com.example.androidbasic.fragments.RedFragment
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        setContentView(R.layout.activity_fragment)

        val oneFragment = OneFragment()
        // asi llamamos a un fragment static
        supportFragmentManager.beginTransaction().add(R.id.contenedorFragments, oneFragment).commit()

        val toolbar = findViewById<Toolbar>(R.id.app_bar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun onClick (view: View) {
        val transaction = supportFragmentManager.beginTransaction()
        val redFragment = RedFragment()

        when (view.id) {
            R.id.buttonRojo -> transaction.replace(R.id.contenedorFragments, redFragment)
            R.id.buttonGreen -> transaction.replace(R.id.contenedorFragments, GreenFragment())
        }

        transaction.addToBackStack(null)
        transaction.commit()
    }
}