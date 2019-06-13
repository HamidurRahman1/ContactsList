package com.hamidur.webCrawler.models;

public class Admin
{
    private int adminId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;

    public Admin() {}

    public Admin(String userName, String password, String firstName, String lastName)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setUserName(userName);
        setPassword(password);
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString()
    {
        return "Admin{" +
                "adminId=" + adminId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
