package com.hamidur.cunyfirst.models.dbModels;

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
    
    @Column(name = "street")
    private String street;
    
    @Column(name = "crossStreet")
    private String crossStreet;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "zipcode")
    private String zipcode;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;
    
    public Address() {}
    
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
    
    public String getZipcode()
    {
        return zipcode;
    }
    
    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
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
        return "Address{" + "addressId=" + addressId + ", street='" + street + '\'' + ", crossStreet='" + crossStreet + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", zipcode='" + zipcode + '\'' + '}';
    }
}
