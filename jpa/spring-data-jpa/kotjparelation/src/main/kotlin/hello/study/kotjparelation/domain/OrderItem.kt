package hello.study.kotjparelation.domain

import javax.persistence.*
import javax.persistence.FetchType.LAZY

@Entity
class OrderItem(
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    var id: Long,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ORDER_ID")
    var order: Order,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ITEM_ID")
    var item: Item,

    var orderPrice: Int,
    var count: Int
) : BaseEntity() {}