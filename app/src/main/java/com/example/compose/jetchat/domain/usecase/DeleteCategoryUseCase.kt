package com.example.compose.jetchat.domain.usecase

import com.example.compose.jetchat.data.local.dao.CategoryDao
import com.example.compose.jetchat.data.local.dao.ExpenseItemDao

class DeleteCategoryUseCase(
    private val categoryDao: CategoryDao,
    private val expenseItemDao: ExpenseItemDao
) {

    suspend fun delete(categoryId: Long) {
        require(!expenseItemDao.hasItemsForCategory(categoryId)) {
            "Category is used by expenses"
        }

        require(!categoryDao.hasChildren(categoryId)) {
            "Category has subcategories"
        }

        categoryDao.delete(categoryId)
    }
}
