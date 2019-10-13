package com.hamidur.cunyfirst.models.generalModels;

public class HighSchoolInfo
{
    private Integer highSchoolId;
    private String highSchoolName;
    private Integer year;
    private String city;
    private String country;
    
    public HighSchoolInfo() {}
    
    public HighSchoolInfo(String highSchoolName, Integer year, String city, String country)
    {
        this.setHighSchoolName(highSchoolName);
        this.setYear(year);
        this.setCity(city);
        this.setCountry(country);
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
        return "HighSchoolInfo{" + "highSchoolId=" + highSchoolId + ", highSchoolName='" + highSchoolName + '\'' + ", year=" + year + ", city='" + city + '\'' + ", country='" + country + '\'' + '}';
    }
}
