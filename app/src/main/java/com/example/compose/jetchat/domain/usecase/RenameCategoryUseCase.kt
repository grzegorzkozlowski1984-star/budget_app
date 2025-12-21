package com.example.compose.jetchat.domain.usecase

import com.example.compose.jetchat.data.local.dao.CategoryDao

class RenameCategoryUseCase(
    private val categoryDao: CategoryDao
) {

    suspend fun rename(id: Long, newName: String) {
        categoryDao.rename(id, newName)
    }
}
