package til.dudu.common.repository

import org.springframework.data.repository.CrudRepository
import til.dudu.common.domain.Member

interface MemberRepository: CrudRepository<Member, Long> {
}