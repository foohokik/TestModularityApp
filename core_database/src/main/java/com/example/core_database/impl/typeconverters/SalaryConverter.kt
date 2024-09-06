package com.example.core_database.impl.typeconverters

import androidx.room.TypeConverter
import com.example.core.data.Address
import com.example.core.data.Salary
import com.google.gson.Gson

class SalaryConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromSalary(salary: Salary): String = gson.toJson(salary)

    @TypeConverter
    fun toSalary (salary: String): Salary = gson.fromJson(salary, Salary::class.java)
}