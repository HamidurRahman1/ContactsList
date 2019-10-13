package com.hamidur.cunyfirst.configs;

import com.hamidur.cunyfirst.models.generalModels.Address;
import com.hamidur.cunyfirst.models.generalModels.Contact;
import com.hamidur.cunyfirst.models.generalModels.Course;
import com.hamidur.cunyfirst.models.generalModels.FAFSA;
import com.hamidur.cunyfirst.models.generalModels.HighSchoolInfo;
import com.hamidur.cunyfirst.models.generalModels.Login;
import com.hamidur.cunyfirst.models.generalModels.SecurityQuestion;
import com.hamidur.cunyfirst.models.generalModels.SecurityQuestionAnswer;
import com.hamidur.cunyfirst.models.generalModels.Student;
import com.hamidur.cunyfirst.models.generalModels.Term;
import com.hamidur.cunyfirst.models.generalModels.TransferInfo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashSet;
import java.util.Set;

@Configuration
@ComponentScan(basePackages = {"com.hamidur.cunyfirst.models"})
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
