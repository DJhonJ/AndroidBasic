package com.example.androidbasic.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbasic.model.Hobby
import com.example.androidbasic.R
import kotlinx.android.synthetic.main.list_item.view.*

//Adaptador para el recycler view
class HobbiesAdapter(val context: Context, val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    // clase interna esta relacionada con el  adaptador
    inner class MyViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView) {
        var currentHobby : Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                //Toast.makeText(context, "${currentHobby?.title} has Clicked !", Toast.LENGTH_SHORT).show()

                val intentDetalle : Intent = Intent(context, DetalleActivity::class.java)
                val bundle : Bundle = Bundle()
                bundle.putSerializable("hobby", currentHobby)
                intentDetalle.putExtras(bundle)
                context.startActivity(intentDetalle)
            }

            //INTENT IMPLICITO
            /*itemView.imgShare.setOnClickListener {
                var text : String = "Hello, i am ${currentHobby?.title}"
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, text)
                intent.type = "text/plain"
                context.startActivity(Intent.createChooser(intent, "Please select App: "))
            }*/
        }

        // funcion para binder los datos del modelo con la vista
        fun setData (hobby : Hobby?, position : Int) {
            hobby?.let {
                itemView.tvTitle.text = hobby.title
            }

            currentHobby = hobby
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }
}

