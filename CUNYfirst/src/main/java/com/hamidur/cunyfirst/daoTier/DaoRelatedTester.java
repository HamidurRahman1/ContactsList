package com.hamidur.cunyfirst.daoTier;

import com.hamidur.cunyfirst.daoTier.models.Address;
import com.hamidur.cunyfirst.daoTier.models.Admin;
import com.hamidur.cunyfirst.daoTier.models.Contact;
import com.hamidur.cunyfirst.daoTier.models.Course;
import com.hamidur.cunyfirst.daoTier.models.CourseName;
import com.hamidur.cunyfirst.daoTier.models.CourseStatus;
import com.hamidur.cunyfirst.daoTier.models.FAFSA;
import com.hamidur.cunyfirst.daoTier.models.Gender;
import com.hamidur.cunyfirst.daoTier.models.HighSchoolInfo;
import com.hamidur.cunyfirst.daoTier.models.Instructor;
import com.hamidur.cunyfirst.daoTier.models.InstructorCourse;
import com.hamidur.cunyfirst.daoTier.models.Login;
import com.hamidur.cunyfirst.daoTier.models.SecurityQuestion;
import com.hamidur.cunyfirst.daoTier.models.Student;
import com.hamidur.cunyfirst.daoTier.models.StudentCourse;
import com.hamidur.cunyfirst.daoTier.models.StudentSecurityQuestion;
import com.hamidur.cunyfirst.daoTier.models.Term;
import com.hamidur.cunyfirst.daoTier.models.TransferInfo;

import com.hamidur.cunyfirst.daoTier.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DaoRelatedTester
{
    public static void main(String[] args)
    {
        Student student = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        student = session.get(Student.class, 10000002);
        Contact contact = student.getContact();
        String e = contact.getCollegeEmail();
        contact.setCollegeEmail(contact.getEmail());
        contact.setEmail(e);
        
        session.update(contact);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
    
//    private static void insertInstructorCourses(Session session, Instructor instructor)
//    {
//        Set<InstructorCourse> instructorCourses = new LinkedHashSet <>();
//        List<Term> terms = session.createQuery("from Term").list();
//        List<Course> courses = session.createQuery("from Course").list();
//        courses.sort(Comparator.comparing(Course::getCourseId));
//
//        InstructorCourse s1 = new InstructorCourse(instructor, courses.get(2), terms.get(3));
//        s1.setInstructor(instructor);
//        InstructorCourse s2 = new InstructorCourse(instructor, courses.get(4), terms.get(1));
//        s2.setInstructor(instructor);
//        InstructorCourse s3 = new InstructorCourse(instructor, courses.get(9), terms.get(3));
//        s3.setInstructor(instructor);
//        InstructorCourse s4 = new InstructorCourse(instructor, courses.get(6), terms.get(2));
//        s4.setInstructor(instructor);
//
//        instructorCourses.addAll(Arrays.asList(s1, s2, s3, s4));
//
//        instructor.setInstructorCourses(instructorCourses);
//        session.save(s1);
//        session.save(s2);
//        session.save(s3);
//        session.save(s4);
//    }
    
    private static void insertStudent(Session session, Student student)
    {
        session.save(student);
    }
    
    private static void insertAdmin(Session session)
    {
        Admin admin = new Admin("demo_first", "demo_last", "090808670", LocalDate.now(), Gender.M);
        session.save(admin);
    }
    
    private static void insertInstructor(Session session, Instructor instructor)
    {
        session.save(instructor);
    }
    
    private static void insertAddresses(Session session, Student student, List<Address> addresses)
    {
        for(int i = 0; i < addresses.size(); i++)
        {
            Address address = addresses.get(i);
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
    
    private static void insertContact(Session session, Student student, Contact contact)
    {
        student.setContact(contact);
        contact.setStudent(student);
        session.save(contact);
    }
    
    private static void insertTerms(Session session, List<Term> terms)
    {
        for(Term term: terms)
        {
            session.save(term);
        }
    }
    
//    private static void insertFafsas(Session session, List<Student> students)
//    {
//        for(Student student: students)
//        {
//            List<FAFSA> fafsas = demoFafsas(getTerms(session));
//            for(FAFSA fafsa: fafsas)
//            {
//                student.addFafsa(fafsa);
//                session.save(fafsa);
//            }
//
//        }
//    }
    
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
    
    private static void insertLogin(Session session, Student student, Login login)
    {
        login.setStudent(student);
        student.setLogin(login);
        session.save(login);
    }
    
    private static void insertTransferInfo(Session session, Student student, TransferInfo transferInfo)
    {
        student.setTransferInfo(transferInfo);
        transferInfo.setStudent(student);
        session.save(transferInfo);
    }
    
//    private static List<Student> getStudents(Session session)
//    {
//        return session.createQuery("from Student").list();
//    }

//    private static List<Term> getTerms(Session session)
//    {
//        return session.createQuery("from Term").list();
//    }
//
//    private static List<SecurityQuestion> getSecurityQuestions(Session session)
//    {
//        return session.createQuery("from SecurityQuestion").list();
//    }
    
    private static List<Student> demoStudents()
    {
        List<Student> students = new LinkedList <>();
//        Student student = new Student();
//        student.setFirstName("Hamidur");
//        student.setLastName("Rahman");
//        student.setSsn("111000111");
//        student.setDateOfBirth(LocalDate.of(1999, 5, 4));
//        student.setGender(Gender.M);
        
        Student student2 = new Student("demo first", "demo last", "657030316", LocalDate.of(1986, 2, 25), Gender.F);
        
//        students.add(student);
        students.add(student2);
        
        return students;
    }
    
    private static List<Address> demoAddresses()
    {
        List<Address> addresses = new LinkedList <>();
        
//        Address address = new Address();
//        address.setStreet("street");
//        address.setCrossStreet("crossStr");
//        address.setCity("city");
//        address.setState("NY");
//        address.setZipCode("11001");
    
        Address address2 = new Address();
        address2.setStreet("demo st");
        address2.setCrossStreet("demo croStr");
        address2.setCity("demo city");
        address2.setState("NY");
        address2.setZipCode("11707");
    
//        addresses.add(address);
        addresses.add(address2);
    
        return addresses;
    }
    
    private static Contact demoContact()
    {
//        Contact contact1 = new Contact();
//        contact1.setPhone("1231231234");
//        contact1.setCellPhone("9098990011");
//        contact1.setEmail("personal@email.com");
//        contact1.setCollegeEmail("collegeEmail@college.edu");
        
        return new Contact("random@email.com", "collegeEmail@college.edu", "1112220000");
    }
    
    private static List<Term> demoTerms()
    {
//        Term t1 = new Term("Spring", 2016);
//        Term t2 = new Term("Fall", 2016);
        Term t3 = new Term("Spring", 2017);
        Term t4 = new Term("Fall", 2017);
        
        return new LinkedList <>(Arrays.asList(t3, t4));
    }
    
//    private static void insertStudentCourses(Session session, Student student)
//    {
//        Set<StudentCourse> studentCourses = new LinkedHashSet <>();
//        List<Term> terms = session.createQuery("from Term").list();
//        List<Course> courses = session.createQuery("from Course").list();
//        courses.sort(Comparator.comparing(Course::getCourseId));
//
//        StudentCourse s1 = new StudentCourse(student, courses.get(3), CourseStatus.TKN, terms.get(0));
//        s1.setStudent(student);
//        StudentCourse s2 = new StudentCourse(student, courses.get(6), CourseStatus.TKN, terms.get(2));
//        s2.setStudent(student);
//        StudentCourse s3 = new StudentCourse(student, courses.get(7), CourseStatus.TKN, terms.get(3));
//        s3.setStudent(student);
//        StudentCourse s4 = new StudentCourse(student, courses.get(9), CourseStatus.TKN, terms.get(1));
//        s4.setStudent(student);
//
//        studentCourses.addAll(Arrays.asList(s1, s2, s3, s4));
//
//        student.setStudentCourses(studentCourses);
//        session.save(s1);
//        session.save(s2);
//        session.save(s3);
//        session.save(s4);
//    }
    
    private static List<Course> demoCourses()
    {
        List<Course> courses = new LinkedList <>();
        
        Course c1 = new Course("Beginner Arts", CourseName.HUA, 101, 3.0f, "description");
        
        Course c2 = new Course("Intermediate Accounting", CourseName.BTA, 111, 3.0f, "description");
        
        Course c3 = new Course("Introduction to Philosophy", CourseName.HUP, 101, 3.0f, "description");
        
        Course c4 = new Course("Public Speaking", CourseName.HUC, 106, 3.0f, "description");
        
        Course c5 = new Course("Physics 1", CourseName.SCP, 231, 4.0f, "description");
        
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
    
    private static Login demoLogin()
    {
        return new Login("fake.user@login.college.edu", "fakepass", false);
    }
    
    private static TransferInfo demoTransferInfo(List<Term> terms)
    {
        return new TransferInfo("Transfer", terms.get(4));
    }
    
    private static Instructor demoInstructor()
    {
        return new Instructor("demo", "demo", "532354352", LocalDate.of(1981, 10, 26), Gender.M);
    }
}
