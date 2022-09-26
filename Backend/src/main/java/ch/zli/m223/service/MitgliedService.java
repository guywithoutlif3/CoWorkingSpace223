package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import ch.zli.m223.model.Mitglied;


@ApplicationScoped
public class MitgliedService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Mitglied createMitglied(Mitglied Mitglied) {
        entityManager.persist(Mitglied);
        return Mitglied;
    }
    @Transactional
    public void deleteMitglied(Long id) {
        var entity = entityManager.find(Mitglied.class, id);
        entityManager.remove(entity);
    }

    public List<Mitglied> findAll() {
        var query = entityManager.createQuery("FROM Mitglied", Mitglied.class);
        return query.getResultList();
    }

    @Transactional
    public Mitglied findById(Long id) {
        return  entityManager.find(Mitglied.class, id);
    }

    @Transactional
    public Mitglied updateMitglied(Long id, Mitglied Mitglied) {
        return entityManager.merge(Mitglied);
    }
}
