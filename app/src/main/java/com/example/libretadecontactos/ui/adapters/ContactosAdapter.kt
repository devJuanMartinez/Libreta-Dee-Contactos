package com.example.libretadecontactos.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.libretadecontactos.data.models.Contactos
import com.example.libretadecontactos.databinding.HolderListacontactosBinding

class ContactosAdapter(private val listener: MyClick
) : RecyclerView.Adapter<ContactosAdapter.MovieHolder>() {
    interface MyClick {
        fun onContactoClick (contactos: Contactos)
    }

    var listado = ArrayList<Contactos>()

    inner class MovieHolder(val binding: HolderListacontactosBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderListacontactosBinding.inflate(layoutInflater, parent, false)
        return MovieHolder(binding)
    }

    override fun getItemCount(): Int {
        return listado.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val contacto = listado[position]
        holder.binding.nombre.text = contacto.nombre
        holder.binding.telefono.text = contacto.telefono.toString()

        holder.itemView.setOnClickListener {
            listener.onContactoClick(contacto)
        }
    }
}