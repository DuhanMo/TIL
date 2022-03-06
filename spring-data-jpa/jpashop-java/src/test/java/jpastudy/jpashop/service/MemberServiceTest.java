package jpastudy.jpashop.service;


import jpastudy.jpashop.domain.Member;
import jpastudy.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void signup() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test
    void duplicate_member_exception() throws Exception{
        //given
        Member member1= new Member();
        member1.setName("kim");
        Member member2= new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
//        memberService.join(member2);

        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //then
//        fail("예외가 발생한다.");
    }

}