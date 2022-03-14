package hello.study.kotjparelation.repository

import hello.study.kotjparelation.domain.Member
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Repository
@Transactional
class MemberRepository(val em: EntityManager) {

    fun save(member: Member): Long? {
        em.persist(member)
        return member.id
    }

    fun findByName(name: String): List<Member> {
        return em.createQuery("select m from Member m where m.name=:name",Member::class.java)
            .setParameter("name", name)
            .resultList
    }

    fun findOne(id: Long): Member {
        return em.find(Member::class.java, id)
    }
}
