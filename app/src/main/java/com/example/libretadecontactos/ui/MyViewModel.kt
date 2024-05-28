package com.example.libretadecontactos.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.libretadecontactos.data.Repositorio
import com.example.libretadecontactos.data.models.Contactos
import kotlinx.coroutines.launch

class MyViewModel(val context: Context): ViewModel() {

    val repositorio = Repositorio(context)

    class MyViewModelFactory(val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java)
                .newInstance(context)
        }
    }

    fun insertaContacto (contacto: Contactos) {
        viewModelScope.launch {
            repositorio.insertaContacto(contacto)
        }
    }

    val allcontactos = repositorio.allContactos
}