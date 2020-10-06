package com.example.androidbasic.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidbasic.R
import com.example.androidbasic.model.Supplier
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter = HobbiesAdapter(
            this,
            Supplier.hobbies
        )
        recyclerView.adapter = adapter
    }
}