package hello.study.kotjparelation.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Category(
    @Id
    @GeneratedValue
    var id: Long? = null,

    var name: String,

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    var parent: Category,

    @OneToMany(mappedBy = "parent")
    var child: List<Category> = arrayListOf(),

    @ManyToMany
    @JoinTable(
        name = "CATEGORY_ITEM",
        joinColumns = [JoinColumn(name = "CATEGORY_ID")],
        inverseJoinColumns = [JoinColumn(name = "ITEM_ID")]
    )
    var items: List<Item> = arrayListOf()
) {}