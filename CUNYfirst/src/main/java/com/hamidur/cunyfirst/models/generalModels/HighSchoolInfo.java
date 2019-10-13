package com.hamidur.cunyfirst.models.generalModels;

import java.util.Objects;

public class HighSchoolInfo
{
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HighSchoolInfo)) return false;
        HighSchoolInfo that = (HighSchoolInfo) o;
        return Objects.equals(getHighSchoolName(), that.getHighSchoolName()) &&
                Objects.equals(getYear(), that.getYear()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getCountry(), that.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHighSchoolName(), getYear(), getCity(), getCountry());
    }

    @Override
    public String toString() {
        return "HighSchoolInfo{" +
                "highSchoolName='" + highSchoolName + '\'' +
                ", year=" + year +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
