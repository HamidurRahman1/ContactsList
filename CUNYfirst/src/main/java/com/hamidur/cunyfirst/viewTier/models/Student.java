package com.hamidur.cunyfirst.viewTier.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Student extends Person implements Serializable
{
    private Integer studentId;
    private Address address;
    private Contact contact;
    private HighSchoolInfo highSchoolInfo;
    private TransferInfo transferInfo;
    private Login login;
    private Map<SecurityQuestion, String> questionsAns = new LinkedHashMap <>(3);
    private Set<FAFSA> fafsas = new LinkedHashSet <>();
    private Set<StudentCourse> studentCourses = new LinkedHashSet <>();
    
    public Student()
    {
        super();
    }
    
    public Student(String firstName, String lastName, String ssn, LocalDate dateOfBirth, Gender gender)
    {
        super(firstName, lastName, ssn, dateOfBirth, gender);
    }
    
    public Integer getStudentId()
    {
        return studentId;
    }
    
    public void setStudentId(Integer studentId)
    {
        this.studentId = studentId;
    }
    
    public Address getAddress()
    {
        return address;
    }
    
    public void setAddress(Address address)
    {
        this.address = address;
    }
    
    public Contact getContact()
    {
        return contact;
    }
    
    public void setContact(Contact contact)
    {
        this.contact = contact;
    }
    
    public HighSchoolInfo getHighSchoolInfo()
    {
        return highSchoolInfo;
    }
    
    public void setHighSchoolInfo(HighSchoolInfo highSchoolInfo)
    {
        this.highSchoolInfo = highSchoolInfo;
    }
    
    public TransferInfo getTransferInfo()
    {
        return transferInfo;
    }
    
    public void setTransferInfo(TransferInfo transferInfo)
    {
        this.transferInfo = transferInfo;
    }
    
    public Map <SecurityQuestion, String> getQuestionsAns()
    {
        return questionsAns;
    }
    
    public void setQuestionsAns(Map <SecurityQuestion, String> questionsAns)
    {
        this.questionsAns = questionsAns;
    }
    
    public Login getLogin()
    {
        return login;
    }
    
    public void setLogin(Login login)
    {
        this.login = login;
    }
    
    public Set<FAFSA> getFafsas()
    {
        return fafsas;
    }
    
    public void setFafsas(Set <FAFSA> fafsas)
    {
        this.fafsas = fafsas;
    }
    
    public void addFafsa(FAFSA fafsa)
    {
        fafsas.add(fafsa);
    }
    
    public void removeFafsa(FAFSA fafsa)
    {
        fafsas.remove(fafsa);
    }
    
    public Set <StudentCourse> getStudentCourses()
    {
        return studentCourses;
    }
    
    public void setStudentCourses(Set <StudentCourse> studentCourses)
    {
        this.studentCourses = studentCourses;
    }
    
    public void addStudentCourse(StudentCourse studentCourse)
    {
        studentCourses.add(studentCourse);
    }
    
    public void removeStudentCourse(StudentCourse studentCourse)
    {
        studentCourses.remove(studentCourse);
    }
    
    @Override
    public String toString()
    {
        return super.toString();
    }
}
