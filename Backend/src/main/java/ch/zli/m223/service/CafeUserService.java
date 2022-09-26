package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import ch.zli.m223.model.CafeUser;


@ApplicationScoped
public class CafeUserService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public CafeUser createCafeUser(CafeUser CafeUser) {
        entityManager.persist(CafeUser);
        return CafeUser;
    }
    
}
