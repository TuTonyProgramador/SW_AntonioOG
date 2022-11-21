package com.example.sw_antonioog.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sw_antonioog.databinding.ItemPersonajeBinding

class StartViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemPersonajeBinding.bind(view)

    fun bind(StarModel:com.example.sw_antonioog.start.Result){
        // Para mostrar el titulo de la pelicula
        binding.Nombre.text = StarModel.name

        // Para mostar la altura
        binding.MostarA.text = StarModel.height

        // Creamos una variable para poder contar el array de peliculas
        var nStar = StarModel.films.count()

        // Para mostrar numero de peliculas
        binding.MostrarNPeli.text = nStar.toString()


    }
}