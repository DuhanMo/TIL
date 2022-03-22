package asia.marketit.service

import asia.marketit.domain.Member
import asia.marketit.repository.MemberRepository
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.springframework.data.repository.findByIdOrNull

internal class MemberServiceTest () {
    private val logger: Logger = mockk()
    private val memberRepository: MemberRepository = mockk()
    private val memberService = MemberService(memberRepository = memberRepository)
    lateinit var member: Member

    @BeforeEach
    fun `setup`() {
        member = Member(1L, "duhan")
        println("setup")
    }

    @Nested
    @DisplayName("멤버 가져오기 테스트")
    inner class GetMember {
        @Test
        @DisplayName(value = "성공")
        fun `when_memberService_find`() {
            //given
            every { memberRepository.findByIdOrNull(1L) } returns member

            //when
            val result = memberService.findOne(1L)

            //then
            assertThat(result?.name).isEqualTo(member.name)
        }
    }
}