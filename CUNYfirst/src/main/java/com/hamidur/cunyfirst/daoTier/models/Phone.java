package com.hamidur.cunyfirst.daoTier.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Phone
{
    @Column(name = "phone", length = 10)
    private String phone;
    
    public Phone() {}
    
    public Phone(String phone)
    {
        this.phone = phone;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(getPhone(), phone.getPhone());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getPhone());
    }
    
    @Override
    public String toString()
    {
        return "phone='" + phone;
    }
}
