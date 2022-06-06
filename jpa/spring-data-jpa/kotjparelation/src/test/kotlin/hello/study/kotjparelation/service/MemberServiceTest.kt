package hello.study.kotjparelation.service

import hello.study.kotjparelation.domain.Member
import hello.study.kotjparelation.domain.Team
import hello.study.kotjparelation.repository.MemberRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.persistence.EntityManager
import javax.transaction.Transactional

@SpringBootTest
@Transactional
internal class MemberServiceTest(
    @Autowired private val memberRepository: MemberRepository,
    @Autowired private val entityManager: EntityManager
) {
    @Test
    fun ad() {
        val member = Member(
            name = "duhan",
            street = "월가",
            zipcode = "12311"
        )

        val team = Team(
            name = "sample-test"
        )
        member.team = team

        entityManager.persist(member)
        entityManager.flush()
        entityManager.clear()
        println("=================")
        val referencedMember = entityManager.getReference(Member::class.java, member.id)
        println("referencedMember.javaClass" + referencedMember.javaClass)
        println("=================")
    }
}