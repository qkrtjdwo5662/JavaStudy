package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        // code

        EntityTransaction ts = em.getTransaction();
        ts.begin();

        try{
            // create
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            // update
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("helloJPA");

            // delete
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                            .getResultList();

            for(Member member: result){
                System.out.println(member.getName());
            }

            ts.commit();
        }catch(Exception e){
            ts.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
