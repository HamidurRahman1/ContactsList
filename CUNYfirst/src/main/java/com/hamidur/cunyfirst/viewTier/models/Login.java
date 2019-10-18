package com.hamidur.cunyfirst.viewTier.models;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class Login implements Serializable
{
    private String username;
    @Size(min = 10, max = 13)
    private String password;
    private Boolean isActive;
    
    public Login() {}
    
    public Login(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    public Login(String username, String password, Boolean isActive)
    {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
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
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof Login)) return false;
        Login login = (Login) o;
        return Objects.equals(getUsername(), login.getUsername())
                && Objects.equals(getPassword(), login.getPassword())
                && Objects.equals(isActive, login.isActive);
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getUsername(), getPassword(), isActive);
    }
    
    @Override
    public String toString()
    {
        return "Login{" + "username='" + username + '\'' + ", password='"
                + password + '\'' + ", isActive=" + isActive + '}';
    }
}
