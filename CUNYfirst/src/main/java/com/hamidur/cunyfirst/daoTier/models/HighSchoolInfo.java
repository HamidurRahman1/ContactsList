package com.hamidur.cunyfirst.daoTier.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;

@Entity(name = "HighSchoolInfo")
@Table(name = "HighSchoolInfos")
public class HighSchoolInfo implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "highSchoolId", nullable = false, updatable = false)
    private Integer highSchoolId;
    
    @Column(name = "highSchoolName", nullable = false, length = 50)
    private String highSchoolName;
    
    @Column(name = "year")
    private Integer year;
    
    @Column(name = "city", nullable = false, length = 15)
    private String city;
    
    @Column(name = "country", nullable = false, length = 15)
    private String country;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;
    
    public HighSchoolInfo() {}
    
    public HighSchoolInfo(String highSchoolName, Integer year, String city, String country)
    {
        this.setHighSchoolName(highSchoolName);
        this.setYear(year);
        this.setCity(city);
        this.setCountry(country);
    }
    
    public HighSchoolInfo(String highSchoolName, Integer year, String city, String country, Student student)
    {
        this.setHighSchoolName(highSchoolName);
        this.setYear(year);
        this.setCity(city);
        this.setCountry(country);
        this.setStudent(student);
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
        return "HighSchoolInfo{" + "highSchoolId=" + highSchoolId + ", highSchoolName='" + highSchoolName + '\'' + ", year=" + year + ", city='" + city + '\'' + ", country='" + country + '\'' + ", student=" + student.getStudentId() + '}';
    }
}
