package hello.study.kotjparelation.service

import hello.study.kotjparelation.domain.Member
import hello.study.kotjparelation.repository.MemberRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val entityManager: EntityManager
) {

    fun register(member: Member): Long? {
        entityManager.persist(member)
        return member.id
//        return memberRepository.save(member)
    }
}