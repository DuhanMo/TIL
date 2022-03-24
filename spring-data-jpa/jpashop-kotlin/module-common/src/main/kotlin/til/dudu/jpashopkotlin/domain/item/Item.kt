package til.dudu.jpashopkotlin.domain.item

import til.dudu.jpashopkotlin.domain.Category
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    open val id: Long? = null,

    open val name: String,
    open val price: Int,
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