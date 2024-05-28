package com.example.libretadecontactos.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.libretadecontactos.data.models.Contactos
import com.example.libretadecontactos.data.models.ContactosDao

@Database(entities = [Contactos::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun contactosDao(): ContactosDao
    companion object{
        const val DBNAME = "contactos_db"

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            val temporalInstance = INSTANCE
            if (temporalInstance != null)
                return temporalInstance

            synchronized(AppDataBase::class.java) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    DBNAME
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}