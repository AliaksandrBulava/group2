package by.jmp.module16.dao.hibernate;

import by.jmp.module16.dao.PersonalDao;
import by.jmp.module16.domain.Personal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public class PersonalDaoImpl implements PersonalDao{

    private EntityManagerFactory emf;
    private EntityManager em;


    public PersonalDaoImpl() {
        emf = Persistence.createEntityManagerFactory("jpa-project");
        em = emf.createEntityManager();
    }

    public Personal create(Personal personal) {
        em.getTransaction().begin();
        em.persist(personal);
        em.getTransaction().commit();
        return personal;
    }

    public Personal get(Long id) {
        return em.find(Personal.class, id);
    }

    public void delete(Long id) {
        Personal personal = em.find(Personal.class, id);
        em.getTransaction().begin();
        em.remove(personal);
        em.getTransaction().commit();
    }

    public Personal update(Personal personal) {
        em.getTransaction().begin();
        em.merge(personal);
        em.getTransaction().commit();
        return personal;
    }

    public void close() {
        em.close();
        emf.close();
    }
}
