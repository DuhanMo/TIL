package hello.study.kotjparelation.domain

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class QueryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val memberRepository: MemberRepository,
    val teamRepository: TeamRepository
) {
    @BeforeEach
    fun setup() {
        val teamA = Team(name = "맨유")
        val teamB = Team(name = "아스날")
        val teamC = Team(name = "첼시")
        val member1 = Member(name = "멤버1", team = teamA)
        val member2 = Member(name = "멤버2", team = teamA)
        val member3 = Member(name = "멤버3", team = teamA)
        val member4 = Member(name = "멤버4", team = teamB)
        val member5 = Member(name = "멤버5", team = teamB)
        val member6 = Member(name = "멤버6", team = teamB)
        entityManager.persist(member1)
        entityManager.persist(member2)
        entityManager.persist(member3)
        entityManager.persist(member4)
        entityManager.persist(member5)
        entityManager.persist(member6)
        entityManager.flush()
    }

    @Test
    fun test() {
        val findAll = teamRepository.findAll()
        println(findAll)
    }
}