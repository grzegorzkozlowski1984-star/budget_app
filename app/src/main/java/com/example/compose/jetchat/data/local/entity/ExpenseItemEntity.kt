package com.example.compose.jetchat.data.local.entity

import androidx.room.*
import java.math.BigDecimal

@Entity(
    tableName = "expense_items",
    foreignKeys = [
        ForeignKey(
            entity = TransactionEntity::class,
            parentColumns = ["id"],
            childColumns = ["transactionId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [
        Index("transactionId"),
        Index("categoryId")
    ]
)
data class ExpenseItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val transactionId: Long,
    val categoryId: Long,
    val amount: BigDecimal,
    val note: String?
)
