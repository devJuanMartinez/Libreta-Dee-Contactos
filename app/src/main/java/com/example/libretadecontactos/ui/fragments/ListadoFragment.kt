package com.example.libretadecontactos.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.InvalidationTracker
import com.example.libretadecontactos.R
import com.example.libretadecontactos.data.models.Contactos
import com.example.libretadecontactos.databinding.ListadocontactosBinding
import com.example.libretadecontactos.ui.MyViewModel
import com.example.libretadecontactos.ui.adapters.ContactosAdapter

class ListadoFragment: Fragment() {

    private var _binding: ListadocontactosBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ContactosAdapter
    private val viewModel by activityViewModels<MyViewModel> {
        MyViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ListadocontactosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_listadoFragment_to_addContactoFragment)
        }

        configRecycler()
        viewModel.allcontactos.observe(viewLifecycleOwner, {
            adapter.updateList(it)
        })
    }

//    val observer = Observer<Contactos>{
//
//
//        configRecycler()
//    }

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