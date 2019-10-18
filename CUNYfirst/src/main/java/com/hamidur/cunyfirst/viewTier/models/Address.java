package com.hamidur.cunyfirst.viewTier.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

public class Address implements Serializable
{
    private Integer addressId;
    
    @NotNull(message = "Street must be provided")
    @Size(min = 1, max = 15)
    private String street;
    
    @NotNull(message = "Cross Street must be provided")
    @Size(min = 1, max = 15)
    private String crossStreet;
    
    @NotNull(message = "City must be provided")
    @Size(min = 1, max = 15)
    private String city;
    
    @NotNull(message = "State must be provided")
    @Size(min = 2, max = 2)
    private String state;
    
    @NotNull(message = "ZipCode must be provided")
    @Size(min = 5, max = 5)
    private String zipCode;
    
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
    
    @Override
    public String toString()
    {
        return "Address{" + "addressId=" + addressId + ", street='" + street + '\'' + ", crossStreet='" +
                crossStreet + '\'' + ", city='" + city + '\'' + ", state='" + state + '\''
                + ", zipCode='" + zipCode + '\'' + '}';
    }
}
