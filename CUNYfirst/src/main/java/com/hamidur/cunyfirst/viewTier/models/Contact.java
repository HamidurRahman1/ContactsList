package com.hamidur.cunyfirst.viewTier.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Contact implements Serializable
{
    private Integer contactId;
    
    @Size(min = 10, max = 10)
    @NotNull(message = "Phone # must be provided")
    private String phone;
    
    @Email(message = "Must be a valid email")
    @Size(max = 25)
    private String email;
    
    @Email(message = "Must be a valid email")
    @Size(max = 50)
    private String collegeEmail;
    
    public Contact() {}
    
    public Contact(String phone, String email, String collegeEmail)
    {
        this.phone = phone;
        this.email = email;
        this.collegeEmail = collegeEmail;
    }
    
    public Integer getContactId()
    {
        return contactId;
    }
    
    public void setContactId(Integer contactId)
    {
        this.contactId = contactId;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getCollegeEmail()
    {
        return collegeEmail;
    }
    
    public void setCollegeEmail(String collegeEmail)
    {
        this.collegeEmail = collegeEmail;
    }
    
    @Override
    public String toString()
    {
        return "Contact{" + "contactId=" + contactId + ", phone='" + phone + '\'' + ", email='"
                + email + '\'' + ", collegeEmail='" + collegeEmail + '\'' + '}';
    }
}
