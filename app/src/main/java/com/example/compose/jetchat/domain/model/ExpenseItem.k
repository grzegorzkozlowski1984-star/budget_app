data class ExpenseItem(
    val id: Long,
    val transactionId: Long,
    val categoryId: Long,
    val amount: Long, // np. grosze
    val description: String?
)
