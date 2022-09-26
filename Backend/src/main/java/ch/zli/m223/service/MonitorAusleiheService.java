package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import ch.zli.m223.model.MonitorAusleihe;


@ApplicationScoped
public class MonitorAusleiheService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public MonitorAusleihe createMonitorAusleihe(MonitorAusleihe MonitorAusleihe) {
        entityManager.persist(MonitorAusleihe);
        return MonitorAusleihe;
    }
    
}
