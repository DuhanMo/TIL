package til.dudu.common.repository

import org.springframework.data.repository.CrudRepository
import til.dudu.common.domain.Order

interface OrderRepository: CrudRepository<Order, Long> {
}