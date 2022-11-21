package com.example.sw_antonioog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sw_antonioog.adapter.StartAdapter
import com.example.sw_antonioog.databinding.ActivityMainBinding
import com.example.sw_antonioog.start.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar e inicializar el recyclerview
        binding.recycler.layoutManager = LinearLayoutManager(this)

        // Creamos una variable del tipo adapter con una lista vacia
        val startAdapter = StartAdapter(emptyList())

        binding.recycler.adapter = startAdapter

        binding.BVer.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val call = getRetrofit().create(APIService::class.java).getStart("people/")
                val star = call.body()

                runOnUiThread {
                    if (call.isSuccessful) {
                        val nuevostar = star?.results ?: emptyList()
                        startAdapter.start = nuevostar
                        startAdapter.notifyDataSetChanged()

                    } else {
                        Toast.makeText(this@MainActivity, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            // Cuando se pulse el boton de guardar
            binding.BGuardar.setOnClickListener {
                val miDialogo = MiDialogFragment()
                miDialogo.show(supportFragmentManager, "MiDialogo")
            }
        }
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}