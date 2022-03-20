package hello.study.kotjparelation.domain

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
open class Item : BaseEntity() {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    var id: Long? = null
    var name: String? = null
    var price: Int = 0
    var stockQuantity: Int = 0

    @ManyToMany(mappedBy = "items")
    var categories: MutableList<Category> = mutableListOf()
}