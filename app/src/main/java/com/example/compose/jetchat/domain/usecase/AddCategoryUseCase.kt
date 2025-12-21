package com.example.compose.jetchat.domain.usecase

import com.example.compose.jetchat.data.local.dao.CategoryDao
import com.example.compose.jetchat.data.local.entity.CategoryEntity

class AddCategoryUseCase(
    private val categoryDao: CategoryDao,
    private val validateDepth: ValidateCategoryDepthUseCase
) {

    suspend fun add(
        name: String,
        parentId: Long?
    ) {
        val all = categoryDao.getAllEntities().associateBy { it.id }
        val parent = parentId?.let { all[it] }

        require(validateDepth.canAddChild(parent, all)) {
            "Maximum category depth exceeded"
        }

        categoryDao.insertEntity(
            CategoryEntity(
                name = name,
                parentId = parentId,
                order = 0
            )
        )
    }
}
