package com.example.libretadecontactos.data.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactosDao {

    @Insert
    suspend fun insertaContacto(vararg contacto: Contactos)

    @Query("SELECT * FROM InfoContactos")
    fun getAllContactos(): LiveData<List<Contactos>>
//
//    @Delete
//    suspend fun eliminaUnContacto(contacto: Contactos)
//
//    @Query("DELETE FROM InfoContactos")
//    suspend fun eliminaTodosContactos(contacto: List<Contactos>)
//
//    @Insert
//    suspend fun actualizaUnContacto(contacto: Contactos)

    //@Query("SELECT * FROM InfoContactos WHERE nombre LIKE :nombre")
}