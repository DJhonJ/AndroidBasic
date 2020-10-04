package com.example.androidbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
    }
}