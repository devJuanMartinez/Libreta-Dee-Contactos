package com.example.libretadecontactos.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.libretadecontactos.data.models.Contactos
import com.example.libretadecontactos.databinding.ListadocontactosBinding
import com.example.libretadecontactos.ui.adapters.ContactosAdapter

class ListadoFragment: Fragment() {

    private var _binding: ListadocontactosBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ContactosAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ListadocontactosBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun configRecycler() {
        val layoutManager = LinearLayoutManager(requireContext())
        adapter = ContactosAdapter(object : ContactosAdapter.MyClick{
            override fun onContactoClick(contactos: Contactos) {
                TODO("Not yet implemented")
            }
        })
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }
}