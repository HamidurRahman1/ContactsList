package com.hamidur.cunyfirst.tests;

import com.hamidur.cunyfirst.models.Address;
import com.hamidur.cunyfirst.models.Contact;
import com.hamidur.cunyfirst.models.FAFSA;
import com.hamidur.cunyfirst.models.HighSchoolInfo;
import com.hamidur.cunyfirst.models.Login;
import com.hamidur.cunyfirst.models.SecurityQuestion;
import com.hamidur.cunyfirst.models.SecurityQuestionAnswer;
import com.hamidur.cunyfirst.models.Student;
import com.hamidur.cunyfirst.models.Term;

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

        System.out.println(student);
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
        student.setLogin(new Login("username@something", "password"));
        student.setQuestionAnswers(questionAnswers());
        student.setFafsas(fafsas());

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




}
