package til.dudu.jpashopkotlin.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("movie")
class Movie(
    override val name: String,
    override val price: Int,
    override var stockQuantity: Int,
    val director: String,
    val actor: String
) : Item(name = name, price = price, stockQuantity = stockQuantity)