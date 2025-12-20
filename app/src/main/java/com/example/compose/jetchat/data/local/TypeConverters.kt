package com.example.compose.jetchat.data.local

import androidx.room.TypeConverter
import java.math.BigDecimal
import java.time.LocalDate

class Converters {

    @TypeConverter
    fun bigDecimalToString(value: BigDecimal?): String? =
        value?.toPlainString()

    @TypeConverter
    fun stringToBigDecimal(value: String?): BigDecimal? =
        value?.let { BigDecimal(it) }

    @TypeConverter
    fun localDateToString(date: LocalDate?): String? =
        date?.toString()

    @TypeConverter
    fun stringToLocalDate(value: String?): LocalDate? =
        value?.let { LocalDate.parse(it) }
}
