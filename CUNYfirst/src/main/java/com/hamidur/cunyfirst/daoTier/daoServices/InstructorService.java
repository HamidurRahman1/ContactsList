package com.hamidur.cunyfirst.daoTier.daoServices;

import com.hamidur.cunyfirst.daoTier.models.Instructor;
import com.hamidur.cunyfirst.daoTier.util.HibernateUtility;
import com.hamidur.cunyfirst.daoTier.util.Utility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class InstructorService
{
    private final SessionFactory sessionFactory;

    public InstructorService(final HibernateUtility hibernateUtility)
    {
        this.sessionFactory = hibernateUtility.getSessionFactory();
    }

    public void insertInstructor(com.hamidur.cunyfirst.viewTier.models.Instructor instructor)
    {
        Session session = sessionFactory.openSession();
        Instructor daoInstructor = Utility.toDaoInstructor(instructor);
        session.save(daoInstructor);
        session.flush();
        session.clear();
        session.getTransaction().commit();
        session.close();
    }

    public void getInstructor(Integer instructorId)
    {
        Session session = sessionFactory.openSession();
        Instructor daoInstructor = session.get(Instructor.class, instructorId);
        // return instructors
        session.flush();
        session.clear();
        session.getTransaction().commit();
        session.close();
    }
}
