package by.jmp.module16.dao.hibernate;

import by.jmp.module16.dao.UnitDao;
import by.jmp.module16.domain.Unit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public class UnitDaoImpl implements UnitDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public UnitDaoImpl() {
        emf = Persistence.createEntityManagerFactory("jpa-project");
        em = emf.createEntityManager();
    }


    public Unit create(Unit unit) {
        em.getTransaction().begin();
        em.persist(unit);
        em.getTransaction().commit();
        return unit;
    }

    public Unit get(Long id) {
        Unit unit = em.find(Unit.class, id);
        return unit;
    }

    public void delete(Long id) {
        Unit unit = em.find(Unit.class, id);
        em.getTransaction().begin();
        em.remove(unit);
        em.getTransaction().commit();
    }

    public Unit update(Unit unit) {
        em.getTransaction().begin();
        em.merge(unit);
        em.getTransaction().commit();
        return unit;
    }

    public void close() {
        em.close();
        emf.close();
    }
}
