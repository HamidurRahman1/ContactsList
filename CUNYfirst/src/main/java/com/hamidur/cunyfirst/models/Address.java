package com.hamidur.cunyfirst.models;

import java.util.Objects;

public class Address
{
    private Integer addressId;
    private String street;
    private String crossStreet;
    private String city;
    private String state;
    private String zipcode;
    
    public Address() {}
    
    public Address(String street, String crossStreet, String city, String state, String zipcode)
    {
        this.setStreet(street);
        this.setCrossStreet(crossStreet);
        this.setCity(city);
        this.setState(state);
        this.setZipcode(zipcode);
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
    
    public String getZipcode()
    {
        return zipcode;
    }
    
    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getAddressId(), address.getAddressId()) &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getCrossStreet(), address.getCrossStreet()) &&
                Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getState(), address.getState()) &&
                Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddressId(), getStreet(), getCrossStreet(), getCity(), getState(), getZipcode());
    }

    @Override
    public String toString()
    {
        return "Address{" + "addressId=" + addressId + ", street='" + street + '\'' + ", crossStreet='" + crossStreet + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", zipcode='" + zipcode + '\'' + '}';
    }
}
