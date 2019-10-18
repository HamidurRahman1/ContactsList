package com.hamidur.cunyfirst.daoTier.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class Person
{
    @Column(name = "firstName", nullable = false, length = 15)
    private String firstName;
    
    @Column(name = "lastName", length = 15)
    private String lastName;
    
    @Column(name = "ssn", unique = true, length = 9)
    private String ssn;
    
    @Column(name = "dob", nullable = false)
    private LocalDate dateOfBirth;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false, length = 1)
    private Gender gender;
    
    public Person() {}
    
    public Person(String firstName, String lastName, String ssn, LocalDate dateOfBirth, Gender gender)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public String getSsn()
    {
        return ssn;
    }
    
    public void setSsn(String ssn)
    {
        this.ssn = ssn;
    }
    
    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
    
    public Gender getGender()
    {
        return gender;
    }
    
    public void setGender(Gender gender)
    {
        this.gender = gender;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getFirstName(), person.getFirstName())
                && Objects.equals(getLastName(), person.getLastName())
                && Objects.equals(getSsn(), person.getSsn())
                && Objects.equals(getDateOfBirth(), person.getDateOfBirth())
                && getGender() == person.getGender();
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getFirstName(), getLastName(), getSsn(), getDateOfBirth(), getGender());
    }
    
    @Override
    public String toString()
    {
        return "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", ssn='"
                + ssn + '\'' + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + "";
    }
}
