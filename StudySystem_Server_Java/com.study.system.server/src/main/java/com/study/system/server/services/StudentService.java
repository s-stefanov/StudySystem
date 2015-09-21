package com.study.system.server.services;

import com.study.system.server.Constants;
import com.study.system.server.domain.IdCounter;
import com.study.system.server.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by xtreme on 5/17/15.
 */
public class StudentService extends AbstractService {
    public StudentService(EntityManagerFactory emf) {
        super(emf);
    }

    public Student getStudentById(String id){
        EntityManager em = createEntityManager();
        Student student = em.find(Student.class, id);
        return student;
    }

    public Object[] getAllStudents(){
        Query q = createEntityManager().createQuery("SELECT x FROM Student x");
        List<?> students = q.getResultList();
        return students.toArray();
    }

    public boolean createStudent(Student student){
        EntityManager em = createEntityManager();
        em.setFlushMode(FlushModeType.COMMIT);

        IdCounter studentIdCounter = this.getIdCounter(em);
        student.setStudentId(String.valueOf(studentIdCounter.getCounter()));

        try{
            em.getTransaction().begin();
            studentIdCounter.incrementCounter();
            em.persist(student);
            em.merge(studentIdCounter);
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
        return Constants.Counters.STUDENT_COUNTER_NAME;
    }

    @Override
    protected String getIdCounterIdentity() {
        return Constants.Counters.STUDENT_COUNTER_ID;
    }
}
