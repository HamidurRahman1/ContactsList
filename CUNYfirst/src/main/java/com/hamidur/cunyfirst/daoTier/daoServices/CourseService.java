package com.hamidur.cunyfirst.daoTier.daoServices;

import com.hamidur.cunyfirst.daoTier.models.Course;
import com.hamidur.cunyfirst.daoTier.util.HibernateUtility;
import com.hamidur.cunyfirst.daoTier.util.Utility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.LinkedList;
import java.util.List;

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
        Course daoCourse = Utility.toDaoCourse(course);
        session.save(daoCourse);
        session.flush();
        session.clear();
        session.getTransaction().commit();
        session.close();
    }

    public List<com.hamidur.cunyfirst.viewTier.models.Course> getCourses()
    {
        Session session = sessionFactory.openSession();
        List<Course> daoCourses =
                session.createQuery("from Course").list();

        List<com.hamidur.cunyfirst.viewTier.models.Course> viewCourses =
                new LinkedList<>();

        for(Course course: daoCourses)
        {
            viewCourses.add(Utility.toViewCourse(course));
        }
        return viewCourses;
    }
}
