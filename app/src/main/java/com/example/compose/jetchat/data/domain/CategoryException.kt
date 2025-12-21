package com.example.compose.jetchat.data.domain

sealed class CategoryException(message: String) : IllegalStateException(message) {

    object TooDeepHierarchy : CategoryException(
        "Category hierarchy cannot exceed 3 levels"
    )

    object ParentNotFound : CategoryException(
        "Parent category does not exist"
    )
}
