package til.dudu.common.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("album")
class Album(
    override var name: String,
    override var price: Int,
    override var stockQuantity: Int,
    val artist: String,
    val etc: String
) : Item(name = name, price = price, stockQuantity = stockQuantity)