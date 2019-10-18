package com.hamidur.cunyfirst.daoTier.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Login")
@Table(name = "Logins")
public class Login
{
    @Id
    @Column(name = "username", updatable = false, nullable = false, unique = true)
    private String userName;
    
    @Column(name = "password", length = 10)
    private String password;
    
    @Column(name = "isActive", columnDefinition = "TINYINT(1)")
    private Boolean isActive;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private Student student;
    
    public Login() {}
    
    public Login(String userName, String password, Boolean isActive)
    {
        this.userName = userName;
        this.password = password;
        this.isActive = isActive;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public Boolean getActive()
    {
        return isActive;
    }
    
    public void setActive(Boolean active)
    {
        isActive = active;
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
        return "Login{" + "userName='" + userName + '\'' + ", password='" + password + '\'' + ", isActive=" + isActive + '}';
    }
}
