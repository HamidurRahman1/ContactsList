package com.hamidur.cunyfirst.viewTier.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable
{
    @NotNull(message = "First name must be provided")
    @Size(min = 1, max = 15)
    private String firstName;
    
    @Size(min = 1, max = 15)
    private String lastName;
    
    @NotNull(message = "SSN must be provided")
    @Size(min = 9, max = 9)
    private String ssn;
    
    @NotNull(message = "Date of birth cannot be empty")
    @PastOrPresent
    private LocalDate dateOfBirth;
    
    @NotNull(message = "Gender must be provided")
    @Size(min = 1, max = 1)
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
    public String toString()
    {
        return "Person{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", ssn='" +
                ssn + '\'' + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + '}';
    }
}
