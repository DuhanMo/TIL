package til.dudu.common.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    val id: Long? = null,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    val orderItems: MutableList<OrderItem> = mutableListOf(),

    val orderDate: LocalDateTime = LocalDateTime.now(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member: Member? = null,

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var delivery: Delivery? = null,

    @Enumerated(value = EnumType.STRING)
    var status: OrderStatus? = null
) {
    fun linkMember(member: Member) {
        this.member = member
        member.orders?.add(this)
    }

    fun addOrderItem(orderItem: OrderItem) {
        orderItems.add(orderItem)
        orderItem.order = this
    }

    fun linkDelivery(delivery: Delivery) {
        this.delivery = delivery
        delivery.order = this
    }

    fun cancel() {
        if (this.delivery?.status == DeliveryStatus.COMP) {
            throw IllegalStateException("이미 배송 완료된 상품은 취소가 불가능 합니다.")
        }
        this.status = OrderStatus.CANCEL
        for (orderItem in orderItems) {
            orderItem.cancel()
        }
    }

    val totalPrice = orderItems.sumOf { it.totalPrice }

    companion object {
        fun createOrder(member: Member, delivery: Delivery, vararg orderItem: OrderItem): Order {
            val order = Order()
            order.linkMember(member)
            order.linkDelivery(delivery)
            for (orderItem in orderItem) {
                order.addOrderItem(orderItem)
            }
            order.status = OrderStatus.ORDER
            return order
        }
    }
}