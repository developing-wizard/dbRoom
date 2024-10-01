package com.example.dbroom

import androidx.room.TypeConverter
import java.util.Date

class Converters {

    @TypeConverter
    fun fromDatetoLong (value : Date) : Long
    {
        return value.time
    }
    @TypeConverter
    fun fromLongtoDate(value: Long) :Date
    {
        return Date(value)
    }
}