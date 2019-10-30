package com.hamidur.cunyfirst.daoTier.daoServices;

import com.hamidur.cunyfirst.daoTier.models.Address;
import com.hamidur.cunyfirst.daoTier.models.Contact;
import com.hamidur.cunyfirst.daoTier.models.HighSchoolInfo;
import com.hamidur.cunyfirst.daoTier.models.Login;
import com.hamidur.cunyfirst.daoTier.models.Person;
import com.hamidur.cunyfirst.daoTier.models.Student;
import com.hamidur.cunyfirst.daoTier.models.TransferInfo;
import com.hamidur.cunyfirst.daoTier.util.HibernateUtility;
import com.hamidur.cunyfirst.daoTier.util.Utility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentService
{
    private final SessionFactory sessionFactory;

    public StudentService(final HibernateUtility hibernateUtility)
    {
        this.sessionFactory = hibernateUtility.getSessionFactory();
    }

    public Integer insertStudent(com.hamidur.cunyfirst.viewTier.models.Student student)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student daoStudent = new Student();

        // set student property
        daoStudent.setPerson(new Person(student.getFirstName(), student.getLastName(), student.getSsn(),
                student.getDateOfBirth(), Utility.toDaoGender(student.getGender())));
        daoStudent.addAddress(Utility.toDaoAddress(student.getAddress()));
        daoStudent.setContact(Utility.toDaoContact(student.getContact()));
        daoStudent.setHighSchoolInfo(Utility.toDaoHighSchoolInfo(student.getHighSchoolInfo()));

        daoStudent.getAddresses().iterator().next().setStudent(daoStudent);
        daoStudent.getContact().setStudent(daoStudent);
        daoStudent.getHighSchoolInfo().setStudent(daoStudent);

        // save student with property
        session.save(daoStudent);

        // create login after persisting student
        Login login = createLogin(session, daoStudent.getPerson(), daoStudent.getStudentId());
        daoStudent.setLogin(login);
        login.setStudent(daoStudent);

        // save login
        session.save(login);

        // create college email
//        String collegeEmail = createEmail()

        session.update(daoStudent);

        session.getTransaction().commit();
        session.close();

        return daoStudent.getStudentId();
    }

    public void getStudent(Integer studentId) {}

    public void getStudents() {}

    public void updateStudent(com.hamidur.cunyfirst.viewTier.models.Student student) {}

    public void deleteStudent(com.hamidur.cunyfirst.viewTier.models.Student student) {}

    public void insertStudentAddress(Integer studentId, com.hamidur.cunyfirst.viewTier.models.Address address) {}
    
    public void getStudentAddress(Integer studentId) {}

    public void updateStudentAddress(Integer studentId, com.hamidur.cunyfirst.viewTier.models.Address address) {}

    public void insertStudentContact(Integer studentId, com.hamidur.cunyfirst.viewTier.models.Contact contact) {}
    
    public void getStudentContact(Integer studentId) {}

    public void updateStudentContact(Integer studentId, com.hamidur.cunyfirst.viewTier.models.Contact contact)
    {}
    
    public void insertStudentHighSchoolInfo
            (Integer studentId, com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo highSchoolInfo)
    {}
    
    public void getStudentHighSchoolInfo(Integer studentId)
    {}
    
    public void updateStudentHighSchoolInfo
            (Integer studentId, com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo highSchoolInfo) {}
    
    public void insertStudentTransferInfo
            (Integer studentId, com.hamidur.cunyfirst.viewTier.models.TransferInfo transferInfo) {}
    
    public void getStudentTransferInfo(Integer studentId)
    {}
    
    public void updateStudentTransferInfo
            (Integer studentId, com.hamidur.cunyfirst.viewTier.models.TransferInfo transferInfo)
    {}
    
    public void validateLogin(String username, String password)
    {}
    
    public void updateStudentPassword(Integer studentId, String newPassword)
    {}
    
    public void insertStudentSecurityQuestions(Integer studentId,
                    Map<com.hamidur.cunyfirst.viewTier.models.SecurityQuestion, String> questionAnswers)
    {}
    
    public void getStudentSecurityQuestions(Integer studentId) {}
    
    public void updateStudentSecurityQuestions(Integer studentId,
                    Map<com.hamidur.cunyfirst.viewTier.models.SecurityQuestion, String> questionAnswers)
    {}
    
    public void insertStudentFafsas(Integer studentId, Set<com.hamidur.cunyfirst.viewTier.models.FAFSA> fafsas) {}
    
    public void getStudentFafsas(Integer studentId) {}
    
    public void updateStudentFafsas(Integer studentId, Set<com.hamidur.cunyfirst.viewTier.models.FAFSA> fafsas) {}
    
    public void insertStudentCourses(Integer studentId, Set<com.hamidur.cunyfirst.viewTier.models.Course> courses) {}
    
    public void getStudentCourses(Integer studentId) {}

    public void getStudentById(Integer studentId) {}
    public void getStudentBySSN(String ssn) {}
    public void getStudentByLogin(String userName, String password) {}

    public boolean isStudentExists(Integer studentId) {return false;}
    public boolean isStudentExists(String ssn) {return false;}
    public boolean isLoginExists(String userName) {return false;}

    public List<com.hamidur.cunyfirst.viewTier.models.Student> getAllStudents() {return new LinkedList<>();}
    public List<com.hamidur.cunyfirst.viewTier.models.Course> getAllCourses() {return new LinkedList<>();}
    public List<com.hamidur.cunyfirst.viewTier.models.Course> getAllCoursesByTerm
            (com.hamidur.cunyfirst.viewTier.models.Term term)
    {return new LinkedList<>();}

    private Login createLogin(Session session, Person person, Integer studentId)
    {
//        boolean flagged = false;
//        List<Login> usernames = session.createQuery("from Login").list();
//        usernames.forEach(e -> System.out.println(e));
        int i = 6;
        String username = person.getFirstName()+"."+person.getLastName()+String.valueOf(studentId).substring(i);
        Login login = new Login();
        login.setUserName(username);
        login.setActive(false);
        return login;
    }
}
