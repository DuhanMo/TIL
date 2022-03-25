package til.dudu.common.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("book")
class Book(
    override var name: String,
    override var price: Int,
    override var stockQuantity: Int,
    val author: String = "",
    val isbn: String = ""
) : Item(name = name, price = price, stockQuantity = stockQuantity)