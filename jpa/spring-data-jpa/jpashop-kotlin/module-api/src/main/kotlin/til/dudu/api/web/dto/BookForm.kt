package til.dudu.api.web.dto

import til.dudu.common.domain.item.Book

data class BookForm(
    val id: Long? = null,
    val name: String,
    val price: Int,
    val stockQuantity: Int,
    val author: String,
    val isbn: String
) {
    fun toEntity(): Book {
        return Book(name = name,
        price = price,
        stockQuantity = stockQuantity,
        author = author,
        isbn = isbn)
    }
}