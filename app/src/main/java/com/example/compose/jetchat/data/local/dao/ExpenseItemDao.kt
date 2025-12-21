package com.example.compose.jetchat.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.compose.jetchat.data.local.entity.ExpenseItemEntity

@Dao
interface ExpenseItemDao {

    @Insert
    suspend fun insertAll(items: List<ExpenseItemEntity>)

    @Query("""
        SELECT SUM(amount) 
        FROM expense_items 
        WHERE categoryId = :categoryId
    """)
    suspend fun sumForCategory(categoryId: Long): Long?
        @Query(
        """
        SELECT COUNT(*) > 0
        FROM expense_items
        WHERE categoryId = :categoryId
        """
    )
    
    suspend fun hasItemsForCategory(categoryId: Long): Boolean
}
