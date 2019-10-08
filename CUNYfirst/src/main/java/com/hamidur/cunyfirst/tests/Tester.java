package com.hamidur.cunyfirst.tests;

import com.hamidur.cunyfirst.models.Address;
import com.hamidur.cunyfirst.models.Contact;
import com.hamidur.cunyfirst.models.Course;
import com.hamidur.cunyfirst.models.FAFSA;
import com.hamidur.cunyfirst.models.HighSchoolInfo;
import com.hamidur.cunyfirst.models.Login;
import com.hamidur.cunyfirst.models.SecurityQuestion;
import com.hamidur.cunyfirst.models.SecurityQuestionAnswer;
import com.hamidur.cunyfirst.models.Student;
import com.hamidur.cunyfirst.models.StudentCourse;
import com.hamidur.cunyfirst.models.Term;
import com.hamidur.cunyfirst.models.TransferInfo;
import com.hamidur.cunyfirst.models.modelProps.CourseLevel;
import com.hamidur.cunyfirst.models.modelProps.CourseName;
import com.hamidur.cunyfirst.models.modelProps.CourseStatus;
import com.hamidur.cunyfirst.models.modelProps.Grade;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Tester
{
    public static void main(String[] args)
    {
        testStudent();
    }

    private static void testStudent()
    {
        Student student = studentWithAllDependencies();
        System.out.println(student.getStudentCourses());
//        System.out.println(student);
    }

    private static Student studentWithAllDependencies()
    {
        Student student = new Student();
        student.setStudentId(1);
        student.setFirstName("first");
        student.setLastName("last");
        student.setSsn("ssn");
        student.setDateOfBirth(LocalDate.of(1999, 10, 20));

        student.setAddress(new Address("St", "cross st", "city", "state", "zipcode"));
        student.setContact(new Contact("homePhone", "personalEmail", "cellPhone","collegeEmail"));
        student.setHighSchoolInfo(new HighSchoolInfo("highScoolName", 2014, "city", "country"));
        student.setLogin(new Login("username@something", "password", student));
        student.setTransferInfo(new TransferInfo("transferSchoolName", new Term("Spring 2016")));
        student.setQuestionAnswers(questionAnswers());
        student.setFafsas(fafsas());
        student.setStudentCourses(studentCourses(student));

        return student;
    }

    private static Set<FAFSA> fafsas()
    {
        Set<FAFSA> fafsas = new LinkedHashSet<>();
        fafsas.add(new FAFSA(2016, 2500.75, new Term("Spring 2016")));
        fafsas.add(new FAFSA(2017, 2250.50, new Term("Fall 2017")));
        return fafsas;
    }

    private static Set<SecurityQuestionAnswer> questionAnswers()
    {
        Set<SecurityQuestionAnswer> questionAnswers = new LinkedHashSet<>();
        questionAnswers.add(new SecurityQuestionAnswer(1, new SecurityQuestion("Q1"), "A1"));
        questionAnswers.add(new SecurityQuestionAnswer(1, new SecurityQuestion("Q2"), "A2"));
        questionAnswers.add(new SecurityQuestionAnswer(1, new SecurityQuestion("Q3"), "A3"));
        return questionAnswers;
    }

    private static Set<StudentCourse> studentCourses(Student student)
    {
        Set<StudentCourse> studentCourses = new LinkedHashSet<>();
        Course c1 = new Course(); c1.setCourseLevel(CourseLevel.Level_101); c1.setCourseName(CourseName.ENG);
        StudentCourse sc1 = new StudentCourse(student, c1, new Term("Spring 2016"), CourseStatus.TAKEN, Grade.A);

        Course c2 = new Course(); c2.setCourseLevel(CourseLevel.Level_101); c2.setCourseName(CourseName.MAC);
        StudentCourse sc2 = new StudentCourse(student, c2, new Term("Spring 2016"), CourseStatus.TAKEN, Grade.A);
        studentCourses.add(sc1);
        studentCourses.add(sc2);
        return studentCourses;
    }
}
