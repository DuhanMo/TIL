package hello.study.kotjparelation.domain

import javax.persistence.*

@Entity
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["USERSNAME"])])
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    var id: Long? = null,

    @Column(name = "USERSNAME", nullable = true, unique = true)
    var name: String,

    var street: String,
    var zipcode: String,

    @OneToMany(mappedBy = "member")
    var orders: List<Order> = mutableListOf()
) : BaseEntity() {}