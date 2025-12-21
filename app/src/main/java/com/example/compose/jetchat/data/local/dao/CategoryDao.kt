package com.example.compose.jetchat.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.compose.jetchat.data.local.entity.CategoryEntity

@Dao
interface CategoryDao {

    @Insert
    suspend fun insert(category: CategoryEntity)

    @Query("SELECT * FROM categories")
    suspend fun getAll(): List<CategoryEntity>

    @Query("SELECT * FROM categories WHERE id = :id LIMIT 1")
    suspend fun getById(id: Long): CategoryEntity?

    @Query("SELECT * FROM categories")
    suspend fun getAllEntities(): List<CategoryEntity>

    @Insert
    suspend fun insertEntity(entity: CategoryEntity)

    @Query("UPDATE categories SET name = :name WHERE id = :id")
    suspend fun rename(id: Long, name: String)

    @Query("UPDATE categories SET parentId = :parentId WHERE id = :id")
    suspend fun updateParent(id: Long, parentId: Long?)

    @Query("DELETE FROM categories WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("SELECT COUNT(*) > 0 FROM categories WHERE parentId = :id")
    suspend fun hasChildren(id: Long): Boolean

}
