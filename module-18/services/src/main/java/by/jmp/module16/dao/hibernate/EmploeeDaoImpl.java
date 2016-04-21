package by.jmp.module16.dao.hibernate;

import by.jmp.module16.domain.Employee;
import by.jmp.module16.dao.EmployeeDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public class EmploeeDaoImpl implements EmployeeDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EmploeeDaoImpl(){
        emf = Persistence.createEntityManagerFactory("jpa-project");
        em = emf.createEntityManager();
    }


    public Employee create(Employee employee) {
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        return employee;
    }

    public Employee get(Long id) {
        return em.find(Employee.class, id);
    }

    public void delete(Long id) {
        Employee employee = em.find(Employee.class, id);
        em.remove(employee);
    }

    public Employee update(Employee employee) {
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
        return employee;
    }

    public void close() {
        em.close();
        emf.close();
    }
}
