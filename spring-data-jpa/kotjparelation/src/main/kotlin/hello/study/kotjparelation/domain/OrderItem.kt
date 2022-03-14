package hello.study.kotjparelation.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
@Entity
class OrderItem(
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    var id: Long,

    @Column(name = "ORDER_ID")
    var orderId: Long,

    @Column(name = "ITEM_ID")
    var itemId: Long,

    var orderPrice: Int,
    var count: Int
)