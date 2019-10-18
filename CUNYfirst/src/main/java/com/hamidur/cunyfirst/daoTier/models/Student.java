package com.hamidur.cunyfirst.daoTier.models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "Student")
@Table(name = "Students")
public class Student implements Serializable
{
    @Id
    @Column(name = "studentId", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "firstName", column = @Column(name = "firstName")),
            @AttributeOverride(name = "lastName", column = @Column(name = "lastName")),
            @AttributeOverride(name = "ssn", column = @Column(name = "ssn")),
            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "dob")),
            @AttributeOverride(name = "gender", column = @Column(name = "gender"))})
    private Person person;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Address> addresses = new LinkedHashSet <>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student",
            cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
    private Set<FAFSA> fafsas = new LinkedHashSet <>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
    private Set<StudentSecurityQuestion> questionAnswers = new LinkedHashSet <>();
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student")
    private Contact contact;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student")
    private Login login;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student")
    private HighSchoolInfo highSchoolInfo;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student")
    private TransferInfo transferInfo;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student",
            cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
    private Set<StudentCourse> studentCourses = new LinkedHashSet <>();
    
    public Student()
    {
        this.person = new Person();
    }
    
    public Student(String firstName, String lastName, String ssn, LocalDate dateOfBirth, Gender gender)
    {
        this.person = new Person(firstName, lastName, ssn, dateOfBirth, gender);
    }
    
    public Integer getStudentId()
    {
        return studentId;
    }
    
    public void setStudentId(Integer studentId)
    {
        this.studentId = studentId;
    }
    
    public Person getPerson()
    {
        return person;
    }
    
    public void setPerson(Person person)
    {
        this.person = person;
    }
    
    public Set<Address> getAddresses()
    {
        return addresses;
    }
    
    public void setAddresses(Set<Address> addresses)
    {
        this.addresses = addresses;
    }
    
    public void addAddress(Address address)
    {
        addresses.add(address);
        address.setStudent(this);
    }
    
    public void removeAddress(Address address)
    {
        addresses.remove(address);
        address.setStudent(null);
    }
    
    public Login getLogin()
    {
        return login;
    }
    
    public void setLogin(Login login)
    {
        this.login = login;
    }
    
    public Contact getContact()
    {
        return contact;
    }
    
    public void setContact(Contact contact)
    {
        this.contact = contact;
    }
    
    public Set<FAFSA> getFafsas()
    {
        return fafsas;
    }
    
    public void setFafsas(Set<FAFSA> fafsas)
    {
        this.fafsas = fafsas;
    }
    
    public void addFafsa(FAFSA fafsa)
    {
        fafsas.add(fafsa);
        fafsa.setStudent(this);
    }
    
    public void removeFafsa(FAFSA fafsa)
    {
        fafsas.remove(fafsa);
        fafsa.setStudent(null);
    }
    
    public Set<StudentSecurityQuestion> getQuestionAnswers()
    {
        return questionAnswers;
    }
    
    public void setQuestionAnswers(Set<StudentSecurityQuestion> questionAnswers)
    {
        this.questionAnswers = questionAnswers;
    }
    
    public void addStudentSecurityQuestion(StudentSecurityQuestion studentSecurityQuestion)
    {
        questionAnswers.add(studentSecurityQuestion);
        studentSecurityQuestion.setStudent(this);
    }
    
    public void removeStudentSecurityQuestion(StudentSecurityQuestion studentSecurityQuestion)
    {
        questionAnswers.remove(studentSecurityQuestion);
        studentSecurityQuestion.setStudent(null);
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
    
    public Set <StudentCourse> getStudentCourses()
    {
        return studentCourses;
    }
    
    public void setStudentCourses(Set<StudentCourse> studentCourses)
    {
        this.studentCourses = studentCourses;
    }
    
    public void addStudentCourse(StudentCourse studentCourse)
    {
        studentCourses.add(studentCourse);
        studentCourse.setStudent(this);
    }
    
    public void removeStudentCourse(StudentCourse studentCourse)
    {
        studentCourses.remove(studentCourse);
        studentCourse.setStudent(null);
    }
    
    @Override
    public String toString()
    {
        return "Student{" + "studentId=" + studentId + ", person=" + person + '}';
    }
}
