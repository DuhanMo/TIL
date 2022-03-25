package til.dudu.api.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import til.dudu.api.web.dto.BookForm
import til.dudu.common.repository.ItemRepository

@SpringBootTest
internal class ItemServiceTest(
    @Autowired private val itemService: ItemService
) {

    @Test
    fun `create_item_from_BookForm`() {
        val bookForm = createBookForm()
        val bookEntity = bookForm.toEntity()
        itemService.saveItem(bookEntity)
    }

    private fun createBookForm(): BookForm {
        return BookForm(
            name = "노인과 바다",
            price = 12000,
            stockQuantity = 100,
            author = "해밍웨이",
            isbn = "123"
        )
    }
}