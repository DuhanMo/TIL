package hello.study.kotjparelation.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "ORDERS")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    var id: Long,

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    var member: Member,

    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    var delivery: Delivery,

    @OneToMany(mappedBy = "order")
    var orderItems: List<OrderItem> = mutableListOf(),

    var orderDate: LocalDateTime,

    @Enumerated(EnumType.STRING)
    var orderStatus: OrderStatus
) : BaseEntity() {}

