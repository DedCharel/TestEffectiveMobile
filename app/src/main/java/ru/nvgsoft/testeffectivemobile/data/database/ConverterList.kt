package ru.nvgsoft.testeffectivemobile.data.database

import androidx.room.TypeConverter
import java.util.stream.Collectors



class ConverterList {

    @TypeConverter
    fun fromList(list: List<String?>): String {
        return list.stream().collect(Collectors.joining("#"))
    }

    @TypeConverter
    fun toString(data: String): List<String> {
        return listOf(*data.split("#".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray())
    }
}