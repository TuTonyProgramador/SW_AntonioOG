package com.example.sw_antonioog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sw_antonioog.R

class StartAdapter(var start:List<com.example.sw_antonioog.start.Result>): RecyclerView.Adapter<StartViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return StartViewHolder(layoutInflater.inflate(R.layout.item_personaje, parent, false))
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        val item = start[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = start.size

}