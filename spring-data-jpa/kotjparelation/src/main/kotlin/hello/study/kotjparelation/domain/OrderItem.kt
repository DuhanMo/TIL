package hello.study.kotjparelation.domain

import javax.persistence.*

@Entity
class OrderItem(
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    var id: Long,

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    var order: Order,

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    var item: Item,

    var orderPrice: Int,
    var count: Int
)