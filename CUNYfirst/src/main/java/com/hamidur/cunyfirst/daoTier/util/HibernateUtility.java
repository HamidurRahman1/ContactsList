package com.hamidur.cunyfirst.daoTier.util;

import com.hamidur.cunyfirst.daoTier.models.Address;
import com.hamidur.cunyfirst.daoTier.models.Admin;
import com.hamidur.cunyfirst.daoTier.models.Contact;
import com.hamidur.cunyfirst.daoTier.models.Course;
import com.hamidur.cunyfirst.daoTier.models.FAFSA;
import com.hamidur.cunyfirst.daoTier.models.HighSchoolInfo;
import com.hamidur.cunyfirst.daoTier.models.Instructor;
import com.hamidur.cunyfirst.daoTier.models.InstructorCourse;
import com.hamidur.cunyfirst.daoTier.models.Login;
import com.hamidur.cunyfirst.daoTier.models.Person;
import com.hamidur.cunyfirst.daoTier.models.Phone;
import com.hamidur.cunyfirst.daoTier.models.SecurityQuestion;
import com.hamidur.cunyfirst.daoTier.models.Student;
import com.hamidur.cunyfirst.daoTier.models.StudentCourse;
import com.hamidur.cunyfirst.daoTier.models.StudentSecurityQuestion;
import com.hamidur.cunyfirst.daoTier.models.Term;
import com.hamidur.cunyfirst.daoTier.models.TransferInfo;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtility
{
    private static final HibernateUtility ourInstance = new HibernateUtility();

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static HibernateUtility getInstance()
    {
        return ourInstance;
    }

    private HibernateUtility() {}

    private static SessionFactory buildSessionFactory()
    {
        Configuration config = new Configuration().addProperties(getProperties())
                                                    .addAnnotatedClass(Student.class)
                                                    .addAnnotatedClass(Address.class)
                                                    .addAnnotatedClass(Term.class)
                                                    .addAnnotatedClass(SecurityQuestion.class)
                                                    .addAnnotatedClass(StudentSecurityQuestion.class)
                                                    .addAnnotatedClass(Login.class)
                                                    .addAnnotatedClass(Contact.class)
                                                    .addAnnotatedClass(HighSchoolInfo.class)
                                                    .addAnnotatedClass(TransferInfo.class)
                                                    .addAnnotatedClass(Course.class)
                                                    .addAnnotatedClass(StudentCourse.class)
                                                    .addAnnotatedClass(FAFSA.class)
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorCourse.class)
                                                    .addAnnotatedClass(Admin.class)
                                                    .addAnnotatedClass(Phone.class)
                                                    .addAnnotatedClass(Person.class);

        StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
        registry.applySettings(config.getProperties());

        ServiceRegistry serviceRegistry = registry.build();

        return config.buildSessionFactory(serviceRegistry);
    }

    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public void closeSessionFactory()
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
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/demo?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC");
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
