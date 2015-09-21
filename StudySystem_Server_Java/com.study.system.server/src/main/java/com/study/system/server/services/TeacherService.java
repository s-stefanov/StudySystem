package com.study.system.server.services;

import com.study.system.server.Constants;
import com.study.system.server.domain.IdCounter;
import com.study.system.server.domain.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xtreme on 5/16/15.
 */
public class TeacherService extends AbstractService{

    public TeacherService(EntityManagerFactory emf){
        super(emf);
    }

    public Teacher getTeacherById(String id){
        EntityManager em = createEntityManager();
        Teacher teacher = em.find(Teacher.class, id);
        return teacher;
    }

    public Object[] getAllTeachers(){
        Query q = createEntityManager().createQuery("SELECT x FROM Teacher x");
        List<?> teachers = q.getResultList();
        return teachers.toArray();
    }

    public boolean createTeacher(Teacher teacher){
        EntityManager em = createEntityManager();
        em.setFlushMode(FlushModeType.COMMIT);

        IdCounter teacherIdCounter = this.getIdCounter(em);
        teacher.setTeacherId(String.valueOf(teacherIdCounter.getCounter()));

        try{
            em.getTransaction().begin();
            teacherIdCounter.incrementCounter();
            em.persist(teacher);
            em.merge(teacherIdCounter);
            em.getTransaction().commit();
        } catch (Exception e){
            return false;
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    protected String getIdCounterName() {
        return Constants.Counters.TEACHER_COUNTER_NAME;
    }

    @Override
    protected String getIdCounterIdentity() {
        return Constants.Counters.TEACHER_COUNTER_ID;
    }
}
