package com.example.compose.jetchat.domain.usecase

import com.example.compose.jetchat.data.local.dao.CategoryDao

class MoveCategoryUseCase(
    private val categoryDao: CategoryDao,
    private val validateDepth: ValidateCategoryDepthUseCase
) {

    suspend fun move(categoryId: Long, newParentId: Long?) {
        val all = categoryDao.getAllEntities().associateBy { it.id }
        val category = all[categoryId] ?: return
        val newParent = newParentId?.let { all[it] }

        require(validateDepth.canAddChild(newParent, all)) {
            "Cannot move category: depth limit exceeded"
        }

        categoryDao.updateParent(categoryId, newParentId)
    }
}
