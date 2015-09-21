package com.study.system.server.services;

import com.study.system.server.domain.IdCounter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by xtreme on 5/16/15.
 */
public abstract class AbstractService {
    EntityManagerFactory emf;
    public AbstractService(EntityManagerFactory emf){
        this.emf = emf;
    }

    protected IdCounter createCounter(String counterId, String counterName) {
        IdCounter idCounter = new IdCounter();
        idCounter.setId(counterId);
        idCounter.setName(counterName);
        idCounter.setCounter(0);
        return idCounter;
    }

    protected abstract String getIdCounterName();

    protected abstract String getIdCounterIdentity();

    protected IdCounter getIdCounter(EntityManager em){
        return getIdCounter(em, getIdCounterName(), getIdCounterIdentity());
    }

    public IdCounter getIdCounter(EntityManager em, String counterName, String counterId){
        Query counterQuery = em.createQuery("SELECT x FROM IdCounter x WHERE x.name = '" +
                counterName + "'");
        IdCounter counterResult;
        try{
            counterResult = (IdCounter) counterQuery.getSingleResult();
        } catch (NoResultException e){
            counterResult = createCounter(counterId, counterName);
        }
        return counterResult;
    }

    protected EntityManager createEntityManager(){
        return emf.createEntityManager();
    }
}
