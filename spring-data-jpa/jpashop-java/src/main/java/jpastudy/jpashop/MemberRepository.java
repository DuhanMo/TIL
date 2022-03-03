package jpastudy.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em; // 스프링부트가 엔티티매니저를 자동으로 빈으로 띄워준다

    // 사이트 이펙트를 줄이기 위해 아이디 정도만 반환한다
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
