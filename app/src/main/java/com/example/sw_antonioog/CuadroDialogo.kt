package com.example.sw_antonioog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MiDialogFragment: DialogFragment()  {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity.let {
            val title = "Guardar"
            val content = "¿Desea guardar el listado?"
            val builder: AlertDialog.Builder= AlertDialog.Builder(requireActivity())
            builder.setTitle(title).setMessage(content)
                .setPositiveButton(android.R.string.ok)  {dialog, which ->
                    Toast.makeText(requireActivity().applicationContext,"Se ha guardado el listado", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(android.R.string.cancel) {dialog, which ->
                    Toast.makeText(requireActivity().applicationContext,"Ha cancelado la accion", Toast.LENGTH_SHORT).show()
                }
            //Devuelve un AlertDialog
            //tal y como lo hemos definido en el builder
            return builder.create()} ?: throw IllegalStateException("El fragmento no está asociado a ninguna actividad")
    }
}