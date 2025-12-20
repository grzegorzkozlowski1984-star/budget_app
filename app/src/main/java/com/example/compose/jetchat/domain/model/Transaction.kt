data class Transaction(
    val id: Long,
    val date: Long, // timestamp
    val note: String?,
    val items: List<ExpenseItem>
)
