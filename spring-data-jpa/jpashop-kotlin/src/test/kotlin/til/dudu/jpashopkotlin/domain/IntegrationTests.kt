package til.dudu.jpashopkotlin.domain


import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ActiveProfiles
import til.dudu.jpashopkotlin.domain.item.Album
import til.dudu.jpashopkotlin.domain.item.Item

@ActiveProfiles("test")
@DataJpaTest
internal class IntegrationTests(
    @Autowired val em: TestEntityManager
) {

    @DisplayName("유저가 앨범을 주문한다")
    @Test
    fun `user_order_album`() {
        val item: Item = Album(
            name = "album1",
            price = 3000,
            stockQuantity = 10,
            artist = "이문세",
            etc = "1집"
        )
        em.persist(item)
        val address = Address(
            city = "인천시 연수구",
            street = "청솔로",
            zipcode = "12344"
        )
        val member = Member(
            name = "모두한",
            address = address
        )
        em.persist(member)
        val orderItem = OrderItem(
            item = item,
            orderPrice = item.price,
            count = 3
        )
        em.persist(orderItem)
    }
}