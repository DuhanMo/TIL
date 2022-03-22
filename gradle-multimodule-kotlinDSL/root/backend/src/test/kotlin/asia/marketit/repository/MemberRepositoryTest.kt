package asia.marketit.repository

import asia.marketit.domain.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
internal class MemberRepositoryTest {
    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Test
    @DisplayName("멤버 저장 성공")
    fun `success_save_member`() {
        val member = Member(name = "duhan")
        entityManager.persist(member)
        entityManager.flush()

        val findMember = memberRepository.findByIdOrNull(member.id)
        assertThat(member).isEqualTo(findMember)
    }
}