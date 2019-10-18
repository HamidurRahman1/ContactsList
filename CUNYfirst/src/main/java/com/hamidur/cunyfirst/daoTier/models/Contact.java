package com.hamidur.cunyfirst.daoTier.models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Contact")
@Table(name = "Contacts")
public class Contact implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contactId", nullable = false, updatable = false)
    private Integer contactId;
    
    @Column(name = "collegeEmail", unique = true, length = 50)
    private String collegeEmail;
    
    @Column(name = "email", unique = true, length = 35, nullable = false)
    private String email;
    
    @Embedded
    @AttributeOverrides(value = {@AttributeOverride(name = "phone", column = @Column(name = "phone"))})
    private Phone phone;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;
    
    public Contact()
    {
        this.phone = new Phone();
    }
    
    public Contact(String collegeEmail, String email, String phone)
    {
        this.collegeEmail = collegeEmail;
        this.email = email;
        this.phone = new Phone(phone);
    }
    
    public Integer getContactId()
    {
        return contactId;
    }
    
    public void setContactId(Integer contactId)
    {
        this.contactId = contactId;
    }
    
    public String getCollegeEmail()
    {
        return collegeEmail;
    }
    
    public void setCollegeEmail(String collegeEmail)
    {
        this.collegeEmail = collegeEmail;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public Phone getPhone()
    {
        return phone;
    }
    
    public void setPhone(Phone phone)
    {
        this.phone = phone;
    }
    
    public Student getStudent()
    {
        return student;
    }
    
    public void setStudent(Student student)
    {
        this.student = student;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getContactId(), contact.getContactId()) && Objects.equals(getCollegeEmail(),
                contact.getCollegeEmail()) && Objects.equals(getEmail(), contact.getEmail())
                && Objects.equals(getPhone(),
                contact.getPhone()) && Objects.equals(getStudent(), contact.getStudent());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getContactId(), getCollegeEmail(), getEmail(), getPhone(), getStudent());
    }
    
    @Override
    public String toString()
    {
        return "Contact{" + "contactId=" + contactId + ", collegeEmail='" + collegeEmail + '\'' + ", email='"
                + email + '\'' + ", phone='" + phone + '\'' + ", student=" + student.getStudentId() + '}';
    }
}
