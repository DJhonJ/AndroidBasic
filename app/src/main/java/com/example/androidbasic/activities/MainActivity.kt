package com.example.androidbasic.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.androidbasic.R
import com.example.androidbasic.`interface`.IClicked
import com.example.androidbasic.fragments.SumarFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IClicked {
    //private var isActiveFragment: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.app_bar)
        setSupportActionBar(toolbar)

        buttonToast.setOnClickListener {
            Toast.makeText(this, "Buttonm was clicked !!", Toast.LENGTH_SHORT).show()
        }

        buttonIr.setOnClickListener {
            var message: String = etMensaje.text.toString()
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)
        }

        buttonRecycler.setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }

        buttonSumar.setOnClickListener {
            supportFragmentManager.beginTransaction().add(R.id.constraintParent, SumarFragment()).commit()
            linearLayoutMainActivity.visibility = View.INVISIBLE

            //isActiveFragment = true
        }
    }

    /*override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isActiveFragment", isActiveFragment)
    }*/

    /*override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val active : Boolean = savedInstanceState.getBoolean("isActiveFragment")
        if (active) {
            linearLayoutMainActivity.visibility = View.INVISIBLE
        }
    }*/

    override fun click (isClicked: Boolean) {
        if (isClicked) {
            linearLayoutMainActivity.visibility = View.INVISIBLE
            Toast.makeText(this, "Llamada desde el fragment", Toast.LENGTH_SHORT).show()
        }
    }

    fun onClick (view: View) {
        view.setOnClickListener {
            startActivity(Intent(this, FragmentActivity::class.java))
        }
    }
}