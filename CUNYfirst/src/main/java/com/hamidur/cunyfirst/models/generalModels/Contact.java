package com.hamidur.cunyfirst.models.generalModels;

import java.util.Objects;

public class Contact
{
    private String homePhone;
    private String cellPhone;
    private String personalEmail;
    private String collegeEmail;
    
    public Contact() {}
    
    public Contact(String homePhone, String personalEmail)
    {
        this(homePhone, personalEmail, null, null);
    }
    
    public Contact(String homePhone, String personalEmail, String cellPhone, String collegeEmail)
    {
        this.setHomePhone(homePhone);
        this.setPersonalEmail(personalEmail);
        this.setCellPhone(cellPhone);
        this.setCollegeEmail(collegeEmail);
    }

    public String getHomePhone()
    {
        return homePhone;
    }
    
    public void setHomePhone(String homePhone)
    {
        this.homePhone = homePhone;
    }
    
    public String getPersonalEmail()
    {
        return personalEmail;
    }
    
    public void setPersonalEmail(String personalEmail)
    {
        this.personalEmail = personalEmail;
    }
    
    public String getCellPhone()
    {
        return cellPhone;
    }
    
    public void setCellPhone(String cellPhone)
    {
        this.cellPhone = cellPhone;
    }
    
    public String getCollegeEmail()
    {
        return collegeEmail;
    }
    
    public void setCollegeEmail(String collegeEmail)
    {
        this.collegeEmail = collegeEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getHomePhone(), contact.getHomePhone()) &&
                Objects.equals(getCellPhone(), contact.getCellPhone()) &&
                Objects.equals(getPersonalEmail(), contact.getPersonalEmail()) &&
                Objects.equals(getCollegeEmail(), contact.getCollegeEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHomePhone(), getCellPhone(), getPersonalEmail(), getCollegeEmail());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "homePhone='" + homePhone + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", personalEmail='" + personalEmail + '\'' +
                ", collegeEmail='" + collegeEmail + '\'' +
                '}';
    }
}
