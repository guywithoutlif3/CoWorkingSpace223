package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import ch.zli.m223.model.Monitor;


@ApplicationScoped
public class MonitorService {
    @Inject
    private EntityManager entityManager;
    
    @Transactional
    public Monitor createMonitor(Monitor Monitor) {
        entityManager.persist(Monitor);
        return Monitor;
    }
    
}
