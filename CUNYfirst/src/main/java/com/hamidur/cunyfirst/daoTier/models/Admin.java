package com.hamidur.cunyfirst.daoTier.models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;


@Entity(name = "Admin")
@Table(name = "Admins")
public class Admin
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminId", nullable = false, updatable = false)
    private Integer adminId;
    
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "firstName", column = @Column(name = "firstName")),
            @AttributeOverride(name = "lastName", column = @Column(name = "lastName")),
            @AttributeOverride(name = "ssn", column = @Column(name = "ssn")),
            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "dob")),
            @AttributeOverride(name = "gender", column = @Column(name = "gender"))})
    private Person person;
    
    public Admin()
    {
        this.person = new Person();
    }
    
    public Admin(String firstName, String lastName, String ssn, LocalDate dateOfBirth, Gender gender)
    {
        this.person = new Person(firstName, lastName, ssn, dateOfBirth, gender);
    }
    
    public void setAdminId(Integer adminId)
    {
        this.adminId = adminId;
    }
    
    public Person getPerson()
    {
        return person;
    }
    
    public void setPerson(Person person)
    {
        this.person = person;
    }
    
    public Integer getAdminId()
    {
        return adminId;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof Admin)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(getAdminId(), admin.getAdminId())
                && Objects.equals(getPerson(), admin.getPerson());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getAdminId(), getPerson().hashCode());
    }
    
    @Override
    public String toString()
    {
        return "Admin{" + "adminId=" + adminId + ", " + person + '}';
    }
}
