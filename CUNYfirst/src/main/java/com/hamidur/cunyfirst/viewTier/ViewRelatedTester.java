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
    
    private static void testStudent()
    {
        Student student = new Student("first", "l", "ssn", LocalDate.now(), Gender.MALE);
        student.setAddress(testAddress());
        student.setContact(testContact());
        student.setHighSchoolInfo(testHighSchoolInfo());
        student.setTransferInfo(testTransferInfo());
        student.setLogin(testLogin());
        
        System.out.println(student.getAddress());
        System.out.println(student.getContact());
        System.out.println(student.getHighSchoolInfo());
        System.out.println(student.getTransferInfo());
        System.out.println(student.getLogin());
    }
    
    private static Address testAddress()
    {
        return new Address("st", "crst", "c", "s", "z");
    }
    
    private static Contact testContact()
    {
        return new Contact("1112220000", "personal", "college");
    }
    
    private static HighSchoolInfo testHighSchoolInfo()
    {
        return new HighSchoolInfo("schoolName", 2014, "city", "country");
    }
    
    private static TransferInfo testTransferInfo()
    {
        return new TransferInfo("schoolName", testTerm());
    }
    
    private static Term testTerm()
    {
        return new Term("Spring", 2016);
    }
    
    private static Login testLogin()
    {
        return new Login("username", "password", false);
    }
}
