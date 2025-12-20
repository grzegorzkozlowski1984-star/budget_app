package com.example.compose.jetchat.data.local.entity

import androidx.room.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity(
    tableName = "transactions"
)
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: LocalDate,
    val description: String?,
    val totalAmount: BigDecimal
)
