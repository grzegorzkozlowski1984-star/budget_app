package com.example.compose.jetchat.data.local.dao

import androidx.room.*
import com.example.compose.jetchat.data.local.entity.TransactionEntity

@Dao
interface TransactionDao {

    @Insert
    suspend fun insert(transaction: TransactionEntity): Long
}
