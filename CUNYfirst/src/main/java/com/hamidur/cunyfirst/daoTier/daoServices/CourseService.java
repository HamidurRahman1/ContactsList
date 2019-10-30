package com.hamidur.cunyfirst.daoTier.daoServices;

import com.hamidur.cunyfirst.daoTier.util.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CourseService
{
    private final SessionFactory sessionFactory;

    public CourseService(final HibernateUtility hibernateUtility)
    {
        this.sessionFactory = hibernateUtility.getSessionFactory();
    }

    public void insertCourse(com.hamidur.cunyfirst.viewTier.models.Course course)
    {
        Session session = sessionFactory.openSession();
//        Course daoCourse = Utility.
        session.flush();
        session.clear();
        session.getTransaction().commit();
        session.close();
    }
}
