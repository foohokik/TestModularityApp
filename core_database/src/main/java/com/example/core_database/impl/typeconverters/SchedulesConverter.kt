package com.example.core_database.impl.typeconverters

import androidx.room.TypeConverter
import com.example.core.data.Experience
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SchedulesConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromList(value: List<String>): String = gson.toJson(value)

    @TypeConverter
    fun toList (value: String): List<String> = gson.fromJson(value, object : TypeToken<List<String>>(){}.type)

}