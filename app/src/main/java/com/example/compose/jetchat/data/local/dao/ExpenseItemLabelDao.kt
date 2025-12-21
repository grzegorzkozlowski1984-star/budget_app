package com.example.compose.jetchat.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.compose.jetchat.data.local.entity.ExpenseItemLabelCrossRef

@Dao
interface ExpenseItemLabelDao {

    @Insert
    suspend fun insert(ref: ExpenseItemLabelCrossRef)

    @Query("DELETE FROM expense_item_labels WHERE expenseItemId = :expenseItemId")
    suspend fun deleteForExpense(expenseItemId: Long)
}
