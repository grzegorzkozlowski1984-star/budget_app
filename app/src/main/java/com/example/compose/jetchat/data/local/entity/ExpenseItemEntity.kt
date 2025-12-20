package com.example.compose.jetchat.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

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
    val id: Long = 0L,

    val transactionId: Long,

    val categoryId: Long,

    /**
     * Kwota przypisana do tej kategorii
     */
    val amount: Double,

    /**
     * Opcjonalna notatka (np. "czekolada Milka")
     */
    val note: String? = null
)

