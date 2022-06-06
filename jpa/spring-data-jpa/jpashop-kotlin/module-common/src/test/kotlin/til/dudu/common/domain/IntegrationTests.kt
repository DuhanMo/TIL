package til.dudu.common.domain


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ActiveProfiles
import til.dudu.common.domain.item.Album
import til.dudu.common.domain.item.Item

@ActiveProfiles("test")
@DataJpaTest
internal class IntegrationTests(
    @Autowired val em: TestEntityManager
) {

    @DisplayName("유저가 앨범을 주문한다")
    @Test
    fun user_order_album() {
        //given
        val member = createUser()
        val item: Item = createItem()
        val orderItem = createOrderItem(item)
        em.persist(item)
        em.persist(member)

        val delivery = Delivery(address = member.address, status = DeliveryStatus.READY)

        val order = Order.createOrder(
            member = member,
            delivery = delivery,
            orderItem = arrayOf(orderItem)
        )
        em.persist(order)
        em.flush()
        em.clear()

        //when
        val findOrder = em.find(Order::class.java, order.id)

        //then
        assertThat(findOrder.member?.id).isEqualTo(member.id)
    }

    private fun createOrderItem(item: Item): OrderItem {
        return OrderItem(
            item = item,
            orderPrice = item.price,
            count = 3
        )
    }

    private fun createItem(): Item {
        return Album(
            name = "album1",
            price = 3000,
            stockQuantity = 10,
            artist = "이문세",
            etc = "1집"
        )
    }

    private fun createUser(): Member {
        val address = Address(
            city = "인천시 연수구",
            street = "청솔로",
            zipcode = "12344"
        )
        return Member(
            name = "모두한",
            address = address
        )
    }
}