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

    fun methodDeleteAndAddedInMainBranch() {
        println("두개의 메서드를 삭제하고 메인브랜치에서 메서드를 추가합니다 -> 충돌유발을 위함")
    }

    fun methodAddedInMainBranch() {}

    fun methodDeleteCommit() {
        println("두개의 메서드를 삭제했습니다.")
    }

    fun methodAddedByTestBranch() {
        println("커밋을 한개 더 쌓습니다.")
    }
}