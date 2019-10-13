package com.hamidur.cunyfirst.models.dbModels;

import javax.persistence.Column;
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
    @Column(name = "contactId")
    private Integer contactId;
    
    @Column(name = "collegeEmail", unique = true)
    private String collegeEmail;
    
    @Column(name = "personalEmail", unique = true)
    private String personalEmail;
    
    @Column(name = "cellPhone")
    private String cellPhone;
    
    @Column(name = "homePhone")
    private String homePhone;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;
    
    public Contact() {}
    
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
    
    public String getPersonalEmail()
    {
        return personalEmail;
    }
    
    public void setPersonalEmail(String personalEmail)
    {
        this.personalEmail = personalEmail;
    }
    
    public String getCellPhone()
    {
        return cellPhone;
    }
    
    public void setCellPhone(String cellPhone)
    {
        this.cellPhone = cellPhone;
    }
    
    public String getHomePhone()
    {
        return homePhone;
    }
    
    public void setHomePhone(String homePhone)
    {
        this.homePhone = homePhone;
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
                contact.getCollegeEmail()) && Objects.equals(getPersonalEmail(), contact.getPersonalEmail())
                && Objects.equals(getCellPhone(), contact.getCellPhone()) && Objects.equals(getHomePhone(),
                contact.getHomePhone()) && Objects.equals(getStudent(), contact.getStudent());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getContactId(), getCollegeEmail(), getPersonalEmail(), getCellPhone(), getHomePhone(), getStudent());
    }
    
    @Override
    public String toString()
    {
        return "Contact{" + "contactId=" + contactId + ", collegeEmail='" + collegeEmail + '\'' + ", personalEmail='" + personalEmail + '\'' + ", cellPhone='" + cellPhone + '\'' + ", homePhone='" + homePhone + '\'' + ", student=" + student.getStudentId() + '}';
    }
}
