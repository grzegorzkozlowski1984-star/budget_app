package com.example.compose.jetchat.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: LocalDateTime,
    val description: String? = null
)
