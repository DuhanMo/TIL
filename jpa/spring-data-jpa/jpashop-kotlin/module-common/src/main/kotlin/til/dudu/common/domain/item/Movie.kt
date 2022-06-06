package til.dudu.common.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("movie")
class Movie(
    override var name: String,
    override var price: Int,
    override var stockQuantity: Int,
    val director: String,
    val actor: String
) : Item(name = name, price = price, stockQuantity = stockQuantity)