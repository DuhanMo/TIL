package til.dudu.common.domain.item

import til.dudu.common.domain.Category
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    open val id: Long? = null,

    open var name: String,
    open var price: Int,
    open var stockQuantity: Int,

    @ManyToMany(mappedBy = "items")
    open var categories: MutableList<Category> = mutableListOf()
) {
    fun addStock(quantity: Int) {
        this.stockQuantity += quantity
    }

    fun removeStock(quantity: Int) {
        if (this.stockQuantity - quantity < 0) {
            throw IllegalArgumentException("need more stock")
        }
        this.stockQuantity -= quantity
    }
}