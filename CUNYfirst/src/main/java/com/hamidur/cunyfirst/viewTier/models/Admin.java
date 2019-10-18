package com.hamidur.cunyfirst.viewTier.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Admin extends Person implements Serializable
{
    private Integer adminId;
    
    public Admin()
    {
        super();
    }
    
    public Admin(String firstName, String lastName, String ssn, LocalDate dateOfBirth, Gender gender)
    {
        super(firstName, lastName, ssn, dateOfBirth, gender);
    }
    
    public Integer getAdminId()
    {
        return adminId;
    }
    
    public void setAdminId(Integer adminId)
    {
        this.adminId = adminId;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof Admin)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(getAdminId(), admin.getAdminId()) && Objects.equals(super.hashCode(), admin.hashCode());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getAdminId(), super.hashCode());
    }
    
    @Override
    public String toString()
    {
        return "Admin{" + "adminId=" + adminId + " " + super.toString() +'}';
    }
}
