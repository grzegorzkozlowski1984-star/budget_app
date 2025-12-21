package com.example.compose.jetchat.domain.usecase

import com.example.compose.jetchat.data.local.entity.CategoryEntity

class ValidateCategoryDepthUseCase {

    fun canAddChild(
        parent: CategoryEntity?,
        all: Map<Long, CategoryEntity>
    ): Boolean {
        var depth = 0
        var current = parent

        while (current != null) {
            depth++
            current = current.parentId?.let { all[it] }
        }

        return depth < 3
    }
}
