package asia.marketit.repository

import asia.marketit.domain.Member
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MemberRepository : JpaRepository<Member, Long> {
    fun findById(id: Long?): Optional<Member>
}