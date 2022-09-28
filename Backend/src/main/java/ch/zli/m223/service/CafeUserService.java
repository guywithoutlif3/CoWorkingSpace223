package ch.zli.m223.service;

import java.util.List;

import javax.annotation.security.PermitAll;
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
    @PermitAll
    public CafeUser createCafeUser(CafeUser cafeUser) {
        entityManager.persist(cafeUser);
        return cafeUser;
    }
    
}
