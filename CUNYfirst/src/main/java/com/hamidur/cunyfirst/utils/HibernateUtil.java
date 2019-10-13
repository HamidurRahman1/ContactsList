package com.hamidur.cunyfirst.utils;


import com.hamidur.cunyfirst.models.dbModels.Address;
import com.hamidur.cunyfirst.models.dbModels.Contact;
import com.hamidur.cunyfirst.models.dbModels.Course;
import com.hamidur.cunyfirst.models.dbModels.FAFSA;
import com.hamidur.cunyfirst.models.dbModels.HighSchoolInfo;
import com.hamidur.cunyfirst.models.dbModels.Login;
import com.hamidur.cunyfirst.models.dbModels.SecurityQuestion;
import com.hamidur.cunyfirst.models.dbModels.Student;
import com.hamidur.cunyfirst.models.dbModels.StudentCourse;
import com.hamidur.cunyfirst.models.dbModels.Term;
import com.hamidur.cunyfirst.models.dbModels.TransferInfo;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil
{
    private static SessionFactory sessionFactory = null;

    private static SessionFactory buildSessionFactory()
    {
        Configuration config = new Configuration().addProperties(getProperties())
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Term.class)
                .addAnnotatedClass(SecurityQuestion.class)
                .addAnnotatedClass(Login.class)
                .addAnnotatedClass(Contact.class)
                .addAnnotatedClass(HighSchoolInfo.class)
                .addAnnotatedClass(TransferInfo.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(StudentCourse.class)
                .addAnnotatedClass(FAFSA.class);

        StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
        registry.applySettings(config.getProperties());

        ServiceRegistry serviceRegistry = registry.build();

        sessionFactory = config.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    public static SessionFactory getSessionFactory()
    {
        if(sessionFactory == null)
        {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void closeSessionFactory()
    {
        if(sessionFactory != null)
        {
            sessionFactory.close();
        }
    }

    private static Properties getProperties()
    {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/cunyfirst?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC");
        properties.setProperty("hibernate.connection.username", "root");
        properties.setProperty("hibernate.connection.password", "mysql?");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("current_session_context_class", "thread");
        properties.setProperty("hibernate.id.new_generator_mappings","false");
        properties.setProperty("hbm2ddl.auto", "update");
        return properties;
    }
}
