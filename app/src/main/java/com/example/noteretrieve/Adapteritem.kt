package com.example.noteretrieve

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itemlayout.view.*

class adapteritem(val context: Context, val input:ArrayList<String>) : RecyclerView.Adapter<adapteritem.itemViewHolder>() {

    class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        val note = input[position]

        holder.itemView.apply {

            tv1.text = note

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        return itemViewHolder(

            LayoutInflater.from(context).inflate(
                R.layout.itemlayout,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = input.size

}
