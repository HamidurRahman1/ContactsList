package com.hamidur.cunyfirst.viewTier;

import com.hamidur.cunyfirst.viewTier.models.Address;
import com.hamidur.cunyfirst.viewTier.models.Contact;
import com.hamidur.cunyfirst.viewTier.models.Gender;
import com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo;
import com.hamidur.cunyfirst.viewTier.models.Login;
import com.hamidur.cunyfirst.viewTier.models.Student;
import com.hamidur.cunyfirst.viewTier.models.Term;
import com.hamidur.cunyfirst.viewTier.models.TransferInfo;

import java.time.LocalDate;

public class ViewRelatedTester
{
    public static void main(String[] args)
    {
        testStudent();
    }
    
    public static Student testStudent()
    {
        Student student = new Student("Hamidur", "Rahman", "ssn", LocalDate.now(), Gender.MALE);
        student.setStudentId(100000001);
        student.setAddress(testAddress());
        student.setContact(testContact());
        student.setHighSchoolInfo(testHighSchoolInfo());
        student.setTransferInfo(testTransferInfo());
        student.setLogin(testLogin());
        return student;
    }
    
    public static Address testAddress()
    {
        return new Address("st", "crst", "city", "street", "zipcode");
    }
    
    public static Contact testContact()
    {
        return new Contact("1112220000", "personal@email.com", "college@college.edu");
    }
    
    public static HighSchoolInfo testHighSchoolInfo()
    {
        return new HighSchoolInfo("Model High School", 2014, "Sylhet", "BD");
    }
    
    public static TransferInfo testTransferInfo()
    {
        return new TransferInfo("schoolName", testTerm());
    }
    
    public static Term testTerm()
    {
        return new Term("Spring", 2016);
    }
    
    public static Login testLogin()
    {
        return new Login("hamidur.rahman@college.edu", "hashfunction", true);
    }
}
