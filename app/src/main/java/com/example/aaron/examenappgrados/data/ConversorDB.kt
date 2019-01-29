package com.example.aaron.examenappgrados.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import android.util.Log

@Database(entities = arrayOf(Conversion::class),version = 1,exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class ConversorDB: RoomDatabase() {
    companion object {
        var sInstance: ConversorDB? = null
        var LOG_TAG = ConversorDB::class.java.simpleName
        val LOCK = Object()
        const val DATABASE_NAME = "conversorDB"

        fun getInstance(context: Context): ConversorDB {
            if (sInstance == null) {
                synchronized(LOCK) {
                    Log.d(LOG_TAG,"Creating Database instance")
                    sInstance = Room.databaseBuilder(context.applicationContext,ConversorDB::class.java, DATABASE_NAME)
                        .build()
                }
            }
            Log.d(LOG_TAG,"GETTING THE DATABSE INSTANCE")
            return sInstance!!
        }
    }
}