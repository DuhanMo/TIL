package til.dudu.jpashopkotlin.domain

import javax.persistence.*

@Entity
class Delivery(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    val id: Long?,

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    var order: Order,

    @Embedded
    val address: Address?,

    @Enumerated(EnumType.STRING)
    val status: DeliveryStatus
)