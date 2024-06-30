package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Team team = new Team();
            team.setName("team1");
            em.persist(team);

            Member member = new Member();
            member.setUsername("team1");
            member.setAge(1);
            member.setTeam(team);
            em.persist(member);

            List<Member> results = em.createQuery("select m from Member m, Team t where m.username = t.name", Member.class)
                    .getResultList();

            for (Member m : results) {
                System.out.println(m.getUsername() );
            }

            tx.commit();
        } catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}
