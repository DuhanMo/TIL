package til.dudu.jpashopkotlin.domain

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

    val orderDate: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member: Member?,

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var delivery: Delivery?,

    @Enumerated(value = EnumType.STRING)
    var status: OrderStatus
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
}