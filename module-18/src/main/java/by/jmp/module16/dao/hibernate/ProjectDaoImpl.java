package by.jmp.module16.dao.hibernate;

import by.jmp.module16.domain.Project;
import by.jmp.module16.dao.ProjectDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public class ProjectDaoImpl implements ProjectDao{

    private EntityManagerFactory emf;
    private EntityManager em;

    public ProjectDaoImpl() {
        emf = Persistence.createEntityManagerFactory("jpa-project");
        em = emf.createEntityManager();
    }

    public Project create(Project project) {
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();
        return project;
    }

    public Project get(Long id) {
        return em.find(Project.class, id);
    }

    public void delete(Long id) {
        Project project = em.find(Project.class, id);
        em.getTransaction().begin();
        em.remove(project);
        em.getTransaction().commit();
    }

    public Project update(Project project) {
        em.getTransaction().begin();
        em.merge(project);
        em.getTransaction().commit();
        return project;
    }

    public void close() {
        em.close();
        emf.close();
    }

}
