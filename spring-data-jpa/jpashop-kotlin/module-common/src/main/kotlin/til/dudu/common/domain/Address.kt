package til.dudu.common.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Address(
    @Column
    val city: String,
    @Column
    val street: String,
    @Column
    val zipcode: String
)