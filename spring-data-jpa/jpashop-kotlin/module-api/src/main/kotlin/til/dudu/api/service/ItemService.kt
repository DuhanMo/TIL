package til.dudu.api.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import til.dudu.api.web.dto.BookForm
import til.dudu.api.web.dto.ItemUpdateForm
import til.dudu.common.domain.item.Item
import til.dudu.common.repository.ItemRepository

@Service
@Transactional(readOnly = true)
class ItemService(
    private val itemRepository: ItemRepository
) {
    @Transactional
    fun saveItem(item: Item) {
        itemRepository.save(item)
    }

    @Transactional
    fun updateItem(itemUpdateForm: ItemUpdateForm) {
        val item = itemRepository.findByIdOrNull(itemUpdateForm.id)
        item.apply {
            item?.name  = itemUpdateForm.name
            item?.price = itemUpdateForm.price
            item?.stockQuantity = itemUpdateForm.stockQuantity
        }
    }

    fun findItemsInMainBranchTwoCommit(): MutableIterable<Item> {
        return itemRepository.findAll()
    }

    fun findOne(itemId: Long): Item? {
        return itemRepository.findByIdOrNull(itemId)
    }
}