package hello.study.kotjparelation.domain

import javax.persistence.*
import javax.persistence.FetchType.LAZY

@Entity
class Category(
    @Id
    @GeneratedValue
    var id: Long? = null,

    var name: String,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "PARENT_ID")
    var parent: Category,

    @OneToMany(mappedBy = "parent")
    var child: MutableList<Category> = mutableListOf(),

    @ManyToMany
    @JoinTable(
        name = "CATEGORY_ITEM",
        joinColumns = [JoinColumn(name = "CATEGORY_ID")],
        inverseJoinColumns = [JoinColumn(name = "ITEM_ID")]
    )
    var items: MutableList<Item> = mutableListOf()
) : BaseEntity() {}