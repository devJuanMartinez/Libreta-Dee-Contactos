package com.example.libretadecontactos.data.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class AppDataBase: RoomDatabase() {

    companion object{
        const val DBNAME = "contactosdb"

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