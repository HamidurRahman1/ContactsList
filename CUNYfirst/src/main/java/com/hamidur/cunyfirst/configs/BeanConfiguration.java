package com.hamidur.cunyfirst.configs;

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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashSet;
import java.util.Set;

@Configuration
@ComponentScan(basePackages = "com.hamidur.cunyfirst")
public class BeanConfiguration
{
    @Bean
    public Student student()
    {
        Student student = new Student();
        student.setFirstName("Hamidur");
        student.setLastName("Rahman");

        student.setAddress(address());
        student.setContact(contact());
        student.setHighSchoolInfo(highSchoolInfo());
        student.setTransferInfo(transferInfo());
        student.setLogin(login());

        student.setStudentCourses(studentCourses());
        student.setFafsas(fafsas());
        student.setQuestionAnswers(questionAnswers());

        return student;
    }

    @Bean
    public Address address()
    {
        return new Address();
    }

    @Bean
    public Contact contact()
    {
        return new Contact();
    }

    @Bean
    public HighSchoolInfo highSchoolInfo()
    {
        return new HighSchoolInfo();
    }

    @Bean
    public TransferInfo transferInfo()
    {
        return new TransferInfo();
    }

    @Bean
    public Login login()
    {
        return new Login();
    }

    @Bean
    public FAFSA fafsa()
    {
        return new FAFSA();
    }

    @Bean
    public Term term()
    {
        return new Term();
    }

    @Bean
    public Course course()
    {
        return new Course();
    }

    @Bean
    public StudentCourse studentCourse()
    {
        return new StudentCourse();
    }

    @Bean
    public SecurityQuestion securityQuestion()
    {
        return new SecurityQuestion();
    }

    @Bean
    public SecurityQuestionAnswer securityQuestionAnswer()
    {
        return new SecurityQuestionAnswer();
    }

    @Bean
    public Set<FAFSA> fafsas()
    {
        return new LinkedHashSet<>();
    }

    @Bean
    public Set<SecurityQuestionAnswer> questionAnswers()
    {
        return new LinkedHashSet<>();
    }

    @Bean
    public Set<StudentCourse> studentCourses()
    {
        return new LinkedHashSet<>();
    }
}
