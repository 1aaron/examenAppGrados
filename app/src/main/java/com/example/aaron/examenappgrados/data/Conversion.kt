package com.example.aaron.examenappgrados.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity
class Conversion(
    @PrimaryKey
    var id: Int,
    var fechaConversion: Date,
    var gCelsius: Float,
    var gFarenheit: Float
    )