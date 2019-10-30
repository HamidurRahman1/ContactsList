package com.hamidur.cunyfirst.daoTier.daoServices;

import com.hamidur.cunyfirst.daoTier.models.Term;
import com.hamidur.cunyfirst.daoTier.util.HibernateUtility;
import com.hamidur.cunyfirst.daoTier.util.Utility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AdminService
{
    private final SessionFactory sessionFactory;

    public AdminService(final HibernateUtility hibernateUtility)
    {
        this.sessionFactory = hibernateUtility.getSessionFactory();
    }

    public void insertTerm(com.hamidur.cunyfirst.viewTier.models.Term term)
    {
        Session session = sessionFactory.openSession();

        Term daoTerm = Utility.toDaoTerm(term);
        session.save(daoTerm);
        session.flush();
        session.clear();
        session.getTransaction().commit();
        session.close();
    }
}
