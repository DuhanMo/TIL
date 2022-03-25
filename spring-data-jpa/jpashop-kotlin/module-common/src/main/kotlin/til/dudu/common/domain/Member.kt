package til.dudu.common.domain

import javax.persistence.*

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    val id: Long? = null,

    val name: String,

    @Embedded
    val address: Address,

    @OneToMany(mappedBy = "member")
    val orders: MutableList<Order>? = mutableListOf()
)