package com.example.core_database.impl.typeconverters

import androidx.room.TypeConverter
import com.example.core.data.SalaryResponse
import com.google.gson.Gson

class SalaryConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromSalary(salary: SalaryResponse): String = gson.toJson(salary)

    @TypeConverter
    fun toSalary (salary: String): SalaryResponse = gson.fromJson(salary, SalaryResponse::class.java)
}