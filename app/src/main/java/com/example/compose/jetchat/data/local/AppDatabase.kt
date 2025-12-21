package com.example.compose.jetchat.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.compose.jetchat.data.local.dao.CategoryDao
import com.example.compose.jetchat.data.local.dao.TransactionDao
import com.example.compose.jetchat.data.local.dao.ExpenseItemDao
import com.example.compose.jetchat.data.local.dao.LabelDao
import com.example.compose.jetchat.data.local.dao.ExpenseItemLabelDao
import com.example.compose.jetchat.domain.model.Category
import com.example.compose.jetchat.domain.model.Transaction
import com.example.compose.jetchat.domain.model.ExpenseItem
import com.example.compose.jetchat.data.local.entity.*
import com.example.compose.jetchat.data.local.entity.LabelEntity
import com.example.compose.jetchat.data.local.entity.ExpenseItemLabelCrossRef

@Database(
    entities = [
        CategoryEntity::class,
        TransactionEntity::class,
        ExpenseItemEntity::class,
        LabelEntity::class,
        ExpenseItemLabelCrossRef::class
    ],
    version = 2
)

@TypeConverters(TypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun transactionDao(): TransactionDao
    abstract fun expenseItemDao(): ExpenseItemDao
    abstract fun labelDao(): LabelDao
    abstract fun expenseItemLabelDao(): ExpenseItemLabelDao

}
