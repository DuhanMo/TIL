package til.dudu.common.repository

import org.springframework.data.repository.CrudRepository
import til.dudu.common.domain.item.Item

interface ItemRepository : CrudRepository<Item, Long> {
}