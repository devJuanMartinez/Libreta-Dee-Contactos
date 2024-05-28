package com.example.libretadecontactos.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.libretadecontactos.R
import com.example.libretadecontactos.data.models.Contactos
import com.example.libretadecontactos.databinding.AddcontactoLayoutBinding
import com.example.libretadecontactos.ui.MyViewModel

class AddContactoFragment: Fragment() {

    private var _binding: AddcontactoLayoutBinding? = null
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<MyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AddcontactoLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btGuardar.setOnClickListener {
            val nombre = binding.etnombre.text.toString()
            val apellidos = binding.etapellidos.text.toString()
//            val telefono = binding.etTelefono.text.toString().toInt()
//            val email = binding.etEmail.text.toString()
//            val edad = binding.etEdad.text.toString().toInt()
//            val fav = binding.cbFavoritos.isChecked

            if (nombre.isNotEmpty() && apellidos.isNotEmpty() ){
                val contactoNuevo = Contactos(nombre, apellidos)
                viewModel.insertaContacto(contactoNuevo)
            }else{
                binding.etnombre.error = "Campo requerido"
                binding.etapellidos.error = "Campo requerido"
                binding.etTelefono.error = "Campo requerido"
                binding.etEmail.error = "Campo requerido"
                binding.etEdad.error = "Campo requerido"
            }

            findNavController().navigateUp()
        }
    }
}
//&& telefono>0 && email.isNotEmpty() && edad>0
//, telefono, email, edad, fav