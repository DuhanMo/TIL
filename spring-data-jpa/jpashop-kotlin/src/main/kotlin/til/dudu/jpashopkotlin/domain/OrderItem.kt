package til.dudu.jpashopkotlin.domain

import til.dudu.jpashopkotlin.domain.item.Item
import javax.persistence.*

@Entity
class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    val item: Item,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    var order: Order? = null,

    val orderPrice: Int,
    val count: Int
) {
    fun cancel() {
        item.addStock(this.count)
    }

    @Transient
    val totalPrice = this.orderPrice * this.count
}