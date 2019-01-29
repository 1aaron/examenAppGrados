package com.example.aaron.examenappgrados.data

import android.arch.persistence.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun toDate(timeStamp: Long): Date {
        return Date(timeStamp)
    }
    @TypeConverter
    fun toTimestamp(date: Date): Long {
        return date.time
    }
}