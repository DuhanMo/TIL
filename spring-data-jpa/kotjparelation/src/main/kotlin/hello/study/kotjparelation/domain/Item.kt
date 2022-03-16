package hello.study.kotjparelation.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Item (
    @Id
    @GeneratedValue
    @Column(name="ITEM_ID")
    var id: Long,

    var name: String,
    var price: Int,
    var stockQuantity: Int
)
