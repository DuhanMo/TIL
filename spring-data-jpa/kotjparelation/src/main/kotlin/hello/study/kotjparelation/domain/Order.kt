package hello.study.kotjparelation.domain

import java.time.LocalDateTime
import javax.persistence.*
import javax.persistence.CascadeType.*
import javax.persistence.FetchType.LAZY

@Entity
@Table(name = "ORDERS")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    var id: Long,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    var member: Member,

    @OneToOne(fetch = LAZY, cascade = [ALL])
    @JoinColumn(name = "DELIVERY_ID")
    var delivery: Delivery,

    @OneToMany(mappedBy = "order", cascade = [ALL])
    var orderItems: MutableList<OrderItem> = mutableListOf(),

    var orderDate: LocalDateTime,

    @Enumerated(EnumType.STRING)
    var orderStatus: OrderStatus
) : BaseEntity() {}

