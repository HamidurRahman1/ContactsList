package com.hamidur.cunyfirst.viewTier.configs.beanConfig;


import com.hamidur.cunyfirst.viewTier.models.Address;
import com.hamidur.cunyfirst.viewTier.models.Contact;
import com.hamidur.cunyfirst.viewTier.models.Course;
import com.hamidur.cunyfirst.viewTier.models.FAFSA;
import com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo;
import com.hamidur.cunyfirst.viewTier.models.Login;
import com.hamidur.cunyfirst.viewTier.models.SecurityQuestion;
import com.hamidur.cunyfirst.viewTier.models.Student;
import com.hamidur.cunyfirst.viewTier.models.StudentCourse;
import com.hamidur.cunyfirst.viewTier.models.Term;
import com.hamidur.cunyfirst.viewTier.models.TransferInfo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@Configuration
@ComponentScan(basePackages = {"com.hamidur.cunyfirst.viewTier.models"})
public class BeanConfiguration
{
    @Bean
    public Student student()
    {
        Student student = new Student();
        student.setFirstName("Hamidur");
        student.setLastName("Rahman");

//        student.setAddress(address());
//        student.setContact(contact());
//        student.setHighSchoolInfo(highSchoolInfo());
//        student.setTransferInfo(transferInfo());
//        student.setLogin(login());
//        student.setFafsas(fafsas());

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
    public Set<FAFSA> fafsas()
    {
        return new LinkedHashSet<>();
    }

    @Bean
    public Map<SecurityQuestion, String> questionAnswers()
    {
        return new LinkedHashMap<>();
    }

    @Bean
    public Set<StudentCourse> studentCourses()
    {
        return new LinkedHashSet<>();
    }
}
