package com.hamidur.cunyfirst.tests;

import com.hamidur.cunyfirst.models.generalModels.Student;
import com.hamidur.cunyfirst.utils.HibernateUtil;
import com.mysql.cj.xdevapi.SessionFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HibernateModelTester
{
    public static void main(String[] args)
    {
        Student student = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Student> students = getStudents(session);

//        insertStudents(session, demoStudents());
//        insertAddresses(session, students, demoAddresses());
//        insertContacts(session, students, demoContacts());
//        insertCourses(session, demoCourses());
//        insertTerms(session, demoTerms());
//        insertFafsas(session, students);
//        insertSecurityQuestion(session, demoQuestions());
//        insertStudentQuestions(session, students, getSecurityQuestions(session));
//        insertHighSchoolInfo(session, students, demoHighSchoolInfo());
//        insertLogins(session, students, demoLogins());
//        insertTransferInfo(session, student, demoTransferInfo(getTerms(session)));

        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }

    private static void insertStudents(Session session, List<Student> students)
    {
        for(Student student: students)
            session.save(student);
    }

    private static void insertAddresses(Session session, List<Student> students, List<Address> addresses)
    {
        for(int i = 0; i < addresses.size(); i++)
        {
            Address address = addresses.get(i);
            Student student = students.get(i);
            student.addAddress(address);
            session.save(address);
        }
    }

    private static void insertCourses(Session session, List<Course> courses)
    {
        for(int i = 0; i < courses.size(); i++)
        {
            Course course = courses.get(i);
            session.save(course);
        }
    }

    private static void insertContacts(Session session, List<Student> students, List<Contact> contacts)
    {
        for(int i = 0; i < students.size(); i++)
        {
            Contact contact = contacts.get(i);
            Student student = students.get(i);
            student.setContact(contact);
            contact.setStudent(student);

            session.save(contact);
        }
    }

    private static void insertTerms(Session session, List<Term> terms)
    {
        for(Term term: terms)
        {
            session.save(term);
        }
    }

    private static void insertFafsas(Session session, List<Student> students)
    {
        for(Student student: students)
        {
            List<FAFSA> fafsas = demoFafsas(getTerms(session));
            for(FAFSA fafsa: fafsas)
            {
                student.addFafsa(fafsa);
                session.save(fafsa);
            }

        }
    }

    private static void insertSecurityQuestion(Session session, List<SecurityQuestion> questions)
    {
        for(SecurityQuestion q: questions)
            session.save(q);
    }

    private static void insertStudentQuestions(Session session, List<Student> students, List<SecurityQuestion> questions)
    {
        for(int i = 0; i < students.size(); i++)
        {
            Student student = students.get(i);
            for(int j = 0; j < 3; j++)
            {
                StudentSecurityQuestion sa = new StudentSecurityQuestion();
                SecurityQuestion s = questions.get(j);
                sa.setSecurityQuestion(s);
                sa.setAnswer("random answer");
                student.addStudentSecurityQuestion(sa);
                session.save(sa);
            }
        }
    }

    private static void insertHighSchoolInfo(Session session, List<Student> students, List<HighSchoolInfo> highSchoolInfos)
    {
        for(int i = 0; i < students.size(); i++)
        {
            Student s = students.get(i);
            HighSchoolInfo h = highSchoolInfos.get(i);

            h.setStudent(s);
            s.setHighSchoolInfo(h);

            session.save(h);
        }
    }

    private static void insertLogins(Session session, List<Student> students, List<Login> logins)
    {
        for(int i = 0; i < students.size(); i++)
        {
            Student s  = students.get(i);
            Login l = logins.get(i);

            l.setStudent(s);
            s.setLogin(l);

            session.save(l);
        }
    }

    private static void insertTransferInfo(Session session, Student student, TransferInfo transferInfo)
    {
        student.setTransferInfo(transferInfo);
        transferInfo.setStudent(student);
        session.save(transferInfo);
    }

    private static List<Student> getStudents(Session session)
    {
        return session.createQuery("from Student").list();
    }

    private static List<Term> getTerms(Session session)
    {
        return session.createQuery("from Term").list();
    }

    private static List<SecurityQuestion> getSecurityQuestions(Session session)
    {
        return session.createQuery("from SecurityQuestion").list();
    }

    private static List<Student> demoStudents()
    {
        List<Student> students = new LinkedList<>();
        Student student = new Student();
        student.setFirstName("Hamidur");
        student.setLastName("Rahman");
        student.setSsn("111000111");
        student.setDateOfBirth(LocalDate.of(1999, 5, 4));
        student.setGender(Gender.M);

        Student student2 = new Student();
        student2.setFirstName("demo first");
        student2.setLastName("demo last");
        student2.setSsn("657030316");
        student2.setDateOfBirth(LocalDate.of(1986, 2, 25));
        student2.setGender(Gender.F);

        students.add(student);
        students.add(student2);

        return students;
    }

    private static List<Address> demoAddresses()
    {
        List<Address> addresses = new LinkedList <>();

        Address address = new Address();
        address.setStreet("street");
        address.setCrossStreet("crossStr");
        address.setCity("city");
        address.setState("NY");
        address.setZipcode("11001");

        Address address2 = new Address();
        address2.setStreet("demo st");
        address2.setCrossStreet("demo croStr");
        address2.setCity("demo city");
        address2.setState("NY");
        address2.setZipcode("11707");

        addresses.add(address);
        addresses.add(address2);

        return addresses;
    }

    private static List<Contact> demoContacts()
    {
        Contact contact1 = new Contact();
        contact1.setHomePhone("1231231234");
        contact1.setCellPhone("9098990011");
        contact1.setPersonalEmail("personal@email.com");
        contact1.setCollegeEmail("collegeEmail@college.edu");

        Contact contact2 = new Contact();
        contact2.setHomePhone("2126310000");
        contact2.setCellPhone("9172323567");
        contact2.setPersonalEmail("personal@email.com");
        contact2.setCollegeEmail("collegeEmail@college.edu");

        return new LinkedList <>(Arrays.asList(contact1, contact2));
    }

    private static List<Term> demoTerms()
    {
        Term t1 = new Term("Spring", 2016);
        Term t2 = new Term("Fall", 2016);
        Term t3 = new Term("Spring", 2017);
        Term t4 = new Term("Fall", 2017);

        return new LinkedList <>(Arrays.asList(t1, t2, t3, t4));
    }

    private static Set<StudentCourse> demoStudentCourses(Session session, Student student)
    {
        Set<StudentCourse> studentCourses = new LinkedHashSet<>();
        List<Term> terms = session.createQuery("from Term").list();
        List<Course> courses = session.createQuery("from Course").list();

        StudentCourse s1 = new StudentCourse(student, courses.get(0), CourseStatus.TKN, terms.get(0));
        StudentCourse s2 = new StudentCourse(student, courses.get(1), CourseStatus.TKN, terms.get(1));
        StudentCourse s3 = new StudentCourse(student, courses.get(3), CourseStatus.TKN, terms.get(1));
        StudentCourse s4 = new StudentCourse(student, courses.get(4), CourseStatus.TKN, terms.get(0));

        studentCourses.addAll(Arrays.asList(s1, s2, s3, s4));
        return studentCourses;
    }

    private static List<Course> demoCourses()
    {
        List<Course> courses = new LinkedList <>();

        Course c1 = new Course("Introduction to College Algebra", CourseName.MAT, CourseLevel.Level_115, 3.0f, "mat 115 description");

        Course c2 = new Course("Introduction to Computer Science", CourseName.MAC, CourseLevel.Level_101, 3.0f, "mac 101 description");

        Course c3 = new Course("Introduction to Poetry", CourseName.ENG, CourseLevel.Level_270, 3.0f, "eng 270 description");

        Course c4 = new Course("Introduction to Biology", CourseName.SCB, CourseLevel.Level_101, 3.0f, "scb 101 description");

        Course c5 = new Course("Advanced C++", CourseName.MAC, CourseLevel.Level_125, 3.0f, "mac 125 description");

        courses.addAll(Arrays.asList(c1, c2, c3, c4, c5));

        return courses;
    }

    private static List<FAFSA> demoFafsas(List<Term> terms)
    {
        List<FAFSA> fafsas = new LinkedList <>();
        FAFSA f1 = new FAFSA();
        f1.setTerm(terms.get(2));
        f1.setAmount(1130.50);

        FAFSA f2 = new FAFSA();
        f2.setTerm(terms.get(1));
        f2.setAmount(2350.75);

        fafsas.add(f1);
        fafsas.add(f2);

        return fafsas;
    }

    private static List<SecurityQuestion> demoQuestions()
    {
        List<SecurityQuestion> questions = new LinkedList <>();

        SecurityQuestion s1 = new SecurityQuestion("What Is your favorite book?");
        SecurityQuestion s2 = new SecurityQuestion("What is the name of the road you grew up on?");
        SecurityQuestion s3 = new SecurityQuestion("What is your mother’s maiden name?");
        SecurityQuestion s4 = new SecurityQuestion("What is your favorite movie?");
        SecurityQuestion s5 = new SecurityQuestion("What is your favorite food?");

        questions.addAll(Arrays.asList(s1, s2, s3, s4, s5));

        return questions;
    }

    private static List<HighSchoolInfo> demoHighSchoolInfo()
    {
        HighSchoolInfo h1 = new HighSchoolInfo("highscool1", 2014, "Sylhet", "Bangladesh");
        HighSchoolInfo h2 = new HighSchoolInfo("demoHighSchool", 2018, "NYC", "USA");
        return new LinkedList <>(Arrays.asList(h1, h2));
    }

    private static List<Login> demoLogins()
    {
        Login l1 = new Login("first.last@login.college.edu", "password1", true);
        Login l2 = new Login("fake.user@login.college.edu", "fakepass", false);
        return new LinkedList <>(Arrays.asList(l1, l2));
    }

    private static TransferInfo demoTransferInfo(List<Term> terms)
    {

        return new TransferInfo("Transfer", terms.get(4));
    }
}
