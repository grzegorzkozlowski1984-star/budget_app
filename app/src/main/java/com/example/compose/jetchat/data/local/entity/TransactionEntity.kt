package com.example.compose.jetchat.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    /**
     * Data i czas transakcji
     */
    val dateTime: LocalDateTime,

    /**
     * Opis / sklep / notatka
     */
    val description: String? = null,

    /**
     * Całkowita kwota transakcji
     * (suma ExpenseItem.amount)
     */
    val totalAmount: Double
)

