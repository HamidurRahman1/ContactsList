package com.hamidur.cunyfirst.viewTier.models;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class HighSchoolInfo implements Serializable
{
    private Integer highSchoolId;
    @Size(min = 10, max = 50)
    private String highSchoolName;
    private Integer year;
    @Size(min = 1, max = 15)
    private String city;
    @Size(min = 2, max = 15)
    private String country;
    
    public HighSchoolInfo() {}
    
    public HighSchoolInfo(String highSchoolName, Integer year, String city, String country)
    {
        this.highSchoolName = highSchoolName;
        this.year = year;
        this.city = city;
        this.country = country;
    }
    
    public Integer getHighSchoolId()
    {
        return highSchoolId;
    }
    
    public void setHighSchoolId(Integer highSchoolId)
    {
        this.highSchoolId = highSchoolId;
    }
    
    public String getHighSchoolName()
    {
        return highSchoolName;
    }
    
    public void setHighSchoolName(String highSchoolName)
    {
        this.highSchoolName = highSchoolName;
    }
    
    public Integer getYear()
    {
        return year;
    }
    
    public void setYear(Integer year)
    {
        this.year = year;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public void setCountry(String country)
    {
        this.country = country;
    }
    
    @Override
    public String toString()
    {
        return "HighSchoolInfo{" + "highSchoolId=" + highSchoolId + ", highSchoolName='"
                + highSchoolName + '\'' + ", year=" + year + ", city='" + city + '\''
                + ", country='" + country + '\'' + '}';
    }
}
