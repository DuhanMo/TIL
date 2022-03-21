package hello.study.kotjparelation.domain

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract class Item : BaseEntity() {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    open var id: Long? = null
    open var name: String? = null
    open var price: Int = 0
    open var stockQuantity: Int = 0

    @ManyToMany(mappedBy = "items")
    open var categories: MutableList<Category> = mutableListOf()
}