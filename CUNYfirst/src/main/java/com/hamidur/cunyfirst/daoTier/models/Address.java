package com.hamidur.cunyfirst.daoTier.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.io.Serializable;

@Entity(name = "Address")
@Table(name = "Addresses")
public class Address implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId", updatable = false, nullable = false)
    private Integer addressId;
    
    @Column(name = "street", nullable = false, length = 15)
    private String street;
    
    @Column(name = "crossStreet", nullable = false, length = 15)
    private String crossStreet;
    
    @Column(name = "city", nullable = false, length = 15)
    private String city;
    
    @Column(name = "state", nullable = false, length = 2)
    private String state;
    
    @Column(name = "zipCode", nullable = false, length = 5)
    private String zipCode;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;
    
    public Address() {}
    
    public Address(String street, String crossStreet, String city, String state, String zipCode)
    {
        this.street = street;
        this.crossStreet = crossStreet;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    public Integer getAddressId()
    {
        return addressId;
    }
    
    public void setAddressId(Integer addressId)
    {
        this.addressId = addressId;
    }
    
    public String getStreet()
    {
        return street;
    }
    
    public void setStreet(String street)
    {
        this.street = street;
    }
    
    public String getCrossStreet()
    {
        return crossStreet;
    }
    
    public void setCrossStreet(String crossStreet)
    {
        this.crossStreet = crossStreet;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public String getState()
    {
        return state;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public String getZipCode()
    {
        return zipCode;
    }
    
    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
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
    public String toString()
    {
        return "Address{" + "addressId=" + addressId + ", street='" + street + '\'' + ", crossStreet='" + crossStreet + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", zipCode='" + zipCode + '\'' + '}';
    }
}
