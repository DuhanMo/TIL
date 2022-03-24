package til.dudu.jpashopkotlin.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("album")
class Album(
    override val name: String,
    override val price: Int,
    override var stockQuantity: Int,
    val artist: String,
    val etc: String
) : Item(name = name, price = price, stockQuantity = stockQuantity)