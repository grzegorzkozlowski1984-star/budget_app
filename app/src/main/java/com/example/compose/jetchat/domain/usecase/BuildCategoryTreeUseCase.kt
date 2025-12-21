package com.example.compose.jetchat.domain.usecase

import com.example.compose.jetchat.data.local.entity.CategoryEntity
import com.example.compose.jetchat.domain.model.CategoryNode

class BuildCategoryTreeUseCase {

    fun build(categories: List<CategoryEntity>): List<CategoryNode> {
        val byParent = categories.groupBy { it.parentId }

        fun buildNode(parentId: Long?): List<CategoryNode> {
            return byParent[parentId].orEmpty().map { entity ->
                CategoryNode(
                    id = entity.id,
                    name = entity.name,
                    children = buildNode(entity.id)
                )
            }
        }

        return buildNode(null)
    }
}
