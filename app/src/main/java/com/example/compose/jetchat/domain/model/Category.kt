data class Category(
    val id: Long,
    val name: String,
    val parentId: Long?, // null = kategoria główna
    val isSystem: Boolean // np. „Inne”
)
