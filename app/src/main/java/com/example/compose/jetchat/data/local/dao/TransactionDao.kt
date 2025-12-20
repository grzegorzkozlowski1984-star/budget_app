package com.example.compose.jetchat.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.compose.jetchat.domain.model.Transaction

@Dao
interface TransactionDao {

    @Insert
    suspend fun insert(transaction: Transaction)

    @Query("SELECT * FROM transactions")
    suspend fun getAll(): List<Transaction>
}
