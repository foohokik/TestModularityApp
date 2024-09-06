package com.example.core_database.impl.typeconverters

import androidx.room.TypeConverter
import com.example.core.data.Address
import com.google.gson.Gson

class AddressConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromAddress(address: Address): String = gson.toJson(address)

    @TypeConverter
    fun toAddress (address: String): Address = gson.fromJson(address, Address::class.java)



}