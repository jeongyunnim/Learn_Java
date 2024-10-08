package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 애플리케이션 로딩 시점에 하나만 만들어 놓아야 한다.
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            List<Member> result = em.createQuery("select m From Member m where m.username like '%kim%'", Member.class)
                            .getResultList();

            for (Member member : result) {
                System.out.println("member = " + member);
            }

            tx.commit();
        } catch(Exception e){
            System.out.println("e = " + e);
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
