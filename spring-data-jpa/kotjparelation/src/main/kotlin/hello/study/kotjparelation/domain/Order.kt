package hello.study.kotjparelation.domain

import java.sql.Blob
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "ORDERS")
@SequenceGenerator(name = "ORDERS_SEQ_GENERATOR",
sequenceName = "ORDERS_SEQUENCE", //매핑할 데이터베이스 시퀀스 이름
initialValue = 1, allocationSize = 50)
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "ORDERS_SEQ_GENERATOR")
    @Column(name = "ORDER_ID")
    var id: Long,
    @Column(name = "MEMBER_ID")
    var memberId: Long,
    var orderDate: LocalDateTime,
    @Enumerated(EnumType.STRING)
    var orderStatus: OrderStatus,
    @Lob
    var description: Blob
) {
}

