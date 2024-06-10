package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    /**
     * 스프링이 entity manager를 만들어서 주입해준다.
     */
//    @PersistenceContext
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    /**
     * SQL: 테이블을 대상으로 쿼리
     * jpql: entity 객체를 대상으로 쿼리
     * "select m from Member m" -> Member 객체에 대한 alias를 m으로 주고, entity Member룰 첮아라.
     */
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) // 첫 번째가 jpql, 두 번째가 반환 타입,
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
