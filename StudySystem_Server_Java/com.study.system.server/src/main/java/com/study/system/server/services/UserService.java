package com.study.system.server.services;

import com.study.system.server.Constants;
import com.study.system.server.domain.IdCounter;
import com.study.system.server.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xtreme on 5/16/15.
 */
public class UserService extends AbstractService{

    public UserService(EntityManagerFactory emf) {
        super(emf);
    }

    public User getUserById(String id){
        EntityManager em = createEntityManager();
        User user = em.find(User.class, id);
        return user;
    }

    public Object[] getAllUsers(){
        Query q = createEntityManager().createQuery("SELECT x FROM User x");
        List<?> users = q.getResultList();
        return users.toArray();
    }

    public boolean createUser(User user){
        EntityManager em = createEntityManager();
        em.setFlushMode(FlushModeType.COMMIT);

        IdCounter idCounter = getIdCounter(em);
        user.setUserId(String.valueOf(idCounter.getCounter()));

        try{
            em.getTransaction().begin();
            idCounter.incrementCounter();
            em.merge(idCounter);
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    protected String getIdCounterName() {
        return Constants.Counters.USER_COUNTER_NAME;
    }

    @Override
    protected String getIdCounterIdentity() {
        return Constants.Counters.USER_COUNTER_ID;
    }
}
