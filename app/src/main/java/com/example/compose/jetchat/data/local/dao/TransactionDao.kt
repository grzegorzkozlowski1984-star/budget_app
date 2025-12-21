package com.example.compose.jetchat.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.compose.jetchat.data.local.entity.TransactionEntity

@Dao
interface TransactionDao {

    @Insert
    suspend fun insert(transaction: TransactionEntity): Long

    @Query("SELECT * FROM transactions")
    suspend fun getAll(): List<TransactionEntity>
    @androidx.room.Transaction
@Query("SELECT * FROM transactions ORDER BY date DESC")
suspend fun getAllWithItems(): List<TransactionWithItems>

}
