package com.example.libretadecontactos.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.libretadecontactos.data.models.Contactos
import com.example.libretadecontactos.data.models.ContactosDao
import com.example.libretadecontactos.data.room.AppDataBase

class Repositorio(context: Context) {

    val database = AppDataBase.getDatabase(context)
    val contactosDao= database.contactosDao()

    val allContactos: LiveData<List<Contactos>> = contactosDao.getAllContactos()

    suspend fun insertaContacto(contactos: Contactos) {
        contactosDao.insertaContacto(contactos)
    }

//    suspend fun eliminaUnContacto(contactos: Contactos) {
//        contactosDao.eliminaUnContacto(contactos)
//    }
//
//    suspend fun eliminaTodosContactos(contactos: List<Contactos>){
//        contactosDao.eliminaTodosContactos(contactos)
//    }
//
//    suspend fun actualizaUnContacto(contactos: Contactos) {
//        contactosDao.actualizaUnContacto(contactos)
//    }




}