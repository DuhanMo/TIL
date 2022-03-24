package til.dudu.jpashopkotlin.domain

import til.dudu.jpashopkotlin.domain.item.Item
import javax.persistence.*
import javax.persistence.FetchType.LAZY

@Entity
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    val id: Long? = null,

    val name: String,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    var parent: Category,

    @OneToMany(mappedBy = "parent")
    val child: MutableList<Category> = mutableListOf(),

    @ManyToMany
    @JoinTable(
        name = "category_item",
        joinColumns = [JoinColumn(name = "category_id")],
        inverseJoinColumns = [JoinColumn(name = "item_id")]
    )
    var items: MutableList<Item> = mutableListOf()
) {
    fun addChildCategory(child: Category) {
        this.child.add(child)
        child.parent = this;
    }
}