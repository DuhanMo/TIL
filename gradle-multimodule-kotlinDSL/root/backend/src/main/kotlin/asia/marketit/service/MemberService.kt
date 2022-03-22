package asia.marketit.service

import asia.marketit.domain.Member
import asia.marketit.repository.MemberRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun register(member: Member): Member {
        logger.info("member={}", member)
        return memberRepository.save(member)
    }

    fun findOne(id: Long): Member? {
        return memberRepository.findByIdOrNull(id)
    }
}