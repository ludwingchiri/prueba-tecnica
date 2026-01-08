package net.xiliosoft.prueba_tecnica.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.xiliosoft.prueba_tecnica.model.Task;

@Stateless
public class TaskRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Task> findAll() {
        return em.createQuery(
            "SELECT t FROM Task t ORDER BY t.createdAt DESC",
            Task.class
        ).getResultList();
    }

    public Task findById(Long id) {
        return em.find(Task.class, id);
    }

    public void save(Task task) {
        if (task.getId() == null) {
            em.persist(task);
        } else {
            em.merge(task);
        }
    }

    public void delete(Task task) {
        em.remove(em.merge(task));
    }
}
