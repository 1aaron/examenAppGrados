package com.example.aaron.examenappgrados.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import com.example.aaron.examenappgrados.data.Conversion

@Dao
interface conversorDao {
    @Insert
    fun insertConversion(conversion: Conversion)


}