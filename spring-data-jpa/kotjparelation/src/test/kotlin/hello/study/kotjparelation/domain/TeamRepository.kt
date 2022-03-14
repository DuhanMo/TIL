package hello.study.kotjparelation.domain

import org.springframework.data.repository.CrudRepository


interface TeamRepository: CrudRepository<Team, Long> {

}