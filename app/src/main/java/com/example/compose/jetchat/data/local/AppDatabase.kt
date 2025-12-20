package com.example.compose.jetchat.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.compose.jetchat.data.local.entity.CategoryEntity
import com.example.compose.jetchat.data.local.entity.ExpenseItemEntity
import com.example.compose.jetchat.data.local.entity.TransactionEntity

@Database(
    entities = [
        CategoryEntity::class,
        TransactionEntity::class,
        ExpenseItemEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    // DAO dodamy w kolejnym kroku
}
