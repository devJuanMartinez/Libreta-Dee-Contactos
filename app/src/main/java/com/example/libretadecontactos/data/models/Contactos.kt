package com.example.libretadecontactos.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "InfoContactos")
data class Contactos(

    val nombre: String,
    val adellidos: String,
    val telefono: Int,
    val email: String,
    val edad: Int,
    val favorito: Boolean
    ) {
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0
    }

