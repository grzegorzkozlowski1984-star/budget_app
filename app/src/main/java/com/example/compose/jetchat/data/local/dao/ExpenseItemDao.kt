package com.example.compose.jetchat.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.compose.jetchat.domain.model.ExpenseItem

@Dao
interface ExpenseItemDao {

    @Insert
    suspend fun insert(item: ExpenseItem)

    @Query("SELECT * FROM expense_items")
    suspend fun getAll(): List<ExpenseItem>
}
