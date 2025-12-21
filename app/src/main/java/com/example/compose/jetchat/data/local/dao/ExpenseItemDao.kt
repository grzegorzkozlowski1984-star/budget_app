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
    """)
    suspend fun hasItemsForCategory(categoryId: Long): Boolean

    @Query("""
    SELECT 
        l.id AS labelId,
        l.name AS labelName,
        SUM(e.amount) AS totalAmount
    FROM expense_items e
    JOIN expense_item_label_cross_ref x
        ON e.id = x.expenseItemId
    JOIN labels l
        ON l.id = x.labelId
    GROUP BY l.id, l.name
    """)
    suspend fun sumExpensesByLabel(): List<ExpenseSumByLabel>

    @Query("""
    SELECT 
        SUM(e.amount)
    FROM expense_items e
    LEFT JOIN expense_item_label_cross_ref x
        ON e.id = x.expenseItemId
    WHERE x.expenseItemId IS NULL
    """)
    suspend fun sumExpensesWithoutLabel(): Double?
}
