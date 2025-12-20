package com.example.compose.jetchat.data.local.dao

import androidx.room.*
import com.example.compose.jetchat.data.local.entity.ExpenseItemEntity

@Dao
interface ExpenseItemDao {

    @Insert
    suspend fun insertAll(items: List<ExpenseItemEntity>)
}
