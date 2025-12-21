package com.example.compose.jetchat.domain.model

data class CategoryNode(
    val id: Long,
    val name: String,
    val children: List<CategoryNode>
)
