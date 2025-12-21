package com.example.compose.jetchat.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.compose.jetchat.data.local.entity.ExpenseItemEntity
import java.time.LocalDateTime
import com.example.compose.jetchat.data.local.query.*

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

    @Query("""
    SELECT
        l.id AS labelId,
        l.name AS labelName,
        c.id AS categoryId,
        c.name AS categoryName,
        SUM(e.amount) AS totalAmount
    FROM expense_items e
    JOIN categories c
        ON c.id = e.categoryId
    JOIN expense_item_label_cross_ref x
        ON e.id = x.expenseItemId
    JOIN labels l
        ON l.id = x.labelId
    GROUP BY l.id, c.id
""")
suspend fun sumExpensesByLabelAndCategory(): List<ExpenseSumByLabelAndCategory>
    @Query("""
        SELECT 
            l.id AS labelId,
            l.name AS labelName,
            SUM(e.amount) AS totalAmount
        FROM expense_items e
        INNER JOIN expense_item_label_cross_ref x 
            ON e.id = x.expenseItemId
        INNER JOIN labels l 
            ON l.id = x.labelId
        INNER JOIN transactions t 
            ON t.id = e.transactionId
        WHERE t.date BETWEEN :from AND :to
        GROUP BY l.id, l.name
    """)
    suspend fun getExpenseSumByLabel(
        from: LocalDateTime,
        to: LocalDateTime
    ): List<ExpenseSumByLabel>


    @Query("""
        SELECT 
            l.id AS labelId,
            l.name AS labelName,
            c.id AS categoryId,
            c.name AS categoryName,
            SUM(e.amount) AS totalAmount
        FROM expense_items e
        INNER JOIN expense_item_label_cross_ref x 
            ON e.id = x.expenseItemId
        INNER JOIN labels l 
            ON l.id = x.labelId
        INNER JOIN categories c 
            ON c.id = e.categoryId
        INNER JOIN transactions t 
            ON t.id = e.transactionId
        WHERE t.date BETWEEN :from AND :to
        GROUP BY l.id, l.name, c.id, c.name
    """)
    suspend fun getExpenseSumByLabelAndCategory(
        from: LocalDateTime,
        to: LocalDateTime
    ): List<ExpenseSumByLabelAndCategory>


    @Query("""
        SELECT SUM(e.amount)
        FROM expense_items e
        LEFT JOIN expense_item_label_cross_ref x 
            ON e.id = x.expenseItemId
        INNER JOIN transactions t 
            ON t.id = e.transactionId
        WHERE x.labelId IS NULL
          AND t.date BETWEEN :from AND :to
    """)
    suspend fun getExpenseSumWithoutLabel(
        from: LocalDateTime,
        to: LocalDateTime
    ): Double?


    @Query("""
        SELECT SUM(e.amount)
        FROM expense_items e
        INNER JOIN transactions t 
            ON t.id = e.transactionId
        WHERE t.date BETWEEN :from AND :to
    """)
    suspend fun getTotalExpenseSum(
        from: LocalDateTime,
        to: LocalDateTime
    ): Double?

}
