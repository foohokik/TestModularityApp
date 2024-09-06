package com.example.core_database.impl.typeconverters

import androidx.room.TypeConverter
import com.example.core.data.Address
import com.example.core.data.Experience
import com.google.gson.Gson

class ExperienceConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromExperience(value: Experience): String = gson.toJson(value)

    @TypeConverter
    fun toExperience (value: String): Experience = gson.fromJson(value, Experience::class.java)

}