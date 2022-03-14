package hello.study.kotjparelation.domain

import org.springframework.data.repository.CrudRepository

interface MemberRepository : CrudRepository<Member, Long>{
}