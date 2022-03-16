package hello.study.kotjparelation.domain

import java.sql.Blob
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

    @OneToMany(mappedBy = "order")
    var orderItems: List<OrderItem> = arrayListOf(),

    var orderDate: LocalDateTime,

    @Enumerated(EnumType.STRING)
    var orderStatus: OrderStatus,

    @Lob
    var description: Blob
)

