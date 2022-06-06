package hello.study.kotjparelation

import hello.study.kotjparelation.domain.Member
import hello.study.kotjparelation.repository.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MemberController(private val repository: MemberRepository) {

    @GetMapping("/save")
    fun saveMember() {
        val member = Member(name = "홍길동", street = "월스트리트", zipcode = "123123")
        val saveId = repository.save(member)
        println(saveId)

    }
}