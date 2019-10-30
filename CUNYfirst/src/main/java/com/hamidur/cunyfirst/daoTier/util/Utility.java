package com.hamidur.cunyfirst.daoTier.util;

import com.hamidur.cunyfirst.daoTier.models.Address;
import com.hamidur.cunyfirst.daoTier.models.Contact;
import com.hamidur.cunyfirst.daoTier.models.Gender;
import com.hamidur.cunyfirst.daoTier.models.Grade;
import com.hamidur.cunyfirst.daoTier.models.HighSchoolInfo;
import com.hamidur.cunyfirst.daoTier.models.Instructor;
import com.hamidur.cunyfirst.daoTier.models.Student;
import com.hamidur.cunyfirst.daoTier.models.Term;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.time.LocalDate;

public class Utility
{
    private ApplicationContext applicationContext;

    public static Instructor toDaoInstructor(com.hamidur.cunyfirst.viewTier.models.Instructor instructor)
    {
        return new Instructor(instructor.getFirstName(), instructor.getLastName(), instructor.getSsn(),
                instructor.getDateOfBirth(), Utility.toDaoGender(instructor.getGender()));
    }

    public static Term toDaoTerm(com.hamidur.cunyfirst.viewTier.models.Term term)
    {
        return new Term(term.getTermName(), term.getTermYear());
    }

    public static LocalDate toLocalDate(Date sqlDate)
    {
        return sqlDate.toLocalDate();
    }

    public static Date toSqlDate(LocalDate localDate)
    {
        return Date.valueOf(localDate);
    }

    public static Gender toDaoGender(com.hamidur.cunyfirst.viewTier.models.Gender gender)
    {
        return Gender.valueOf(gender.getValue());
    }

    public static com.hamidur.cunyfirst.viewTier.models.Gender toViewGender(Gender gender)
    {
        if(gender.name().equals(com.hamidur.cunyfirst.viewTier.models.Gender.MALE.getValue()))
            return com.hamidur.cunyfirst.viewTier.models.Gender.MALE;
        else if(gender.name().equals(com.hamidur.cunyfirst.viewTier.models.Gender.FEMALE.getValue()))
            return com.hamidur.cunyfirst.viewTier.models.Gender.FEMALE;
        else return com.hamidur.cunyfirst.viewTier.models.Gender.OTHER;
    }


    public static Address toDaoAddress(com.hamidur.cunyfirst.viewTier.models.Address address)
    {
        return new Address(address.getStreet(), address.getCrossStreet(),
                address.getCity(), address.getState(), address.getZipCode());
    }

    public static com.hamidur.cunyfirst.viewTier.models.Address toViewAddress(Address address)
    {
        return new com.hamidur.cunyfirst.viewTier.models.Address(address.getStreet(), address.getCrossStreet(),
                address.getCity(), address.getState(), address.getZipCode());
    }

    public static Contact toDaoContact(com.hamidur.cunyfirst.viewTier.models.Contact contact)
    {
        return new Contact(contact.getCollegeEmail(), contact.getEmail(), contact.getPhone());
    }

    public static HighSchoolInfo toDaoHighSchoolInfo(com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo schoolInfo)
    {
        return new HighSchoolInfo(schoolInfo.getHighSchoolName(), schoolInfo.getYear(), schoolInfo.getCity(),
                schoolInfo.getCountry());
    }

    public static com.hamidur.cunyfirst.viewTier.models.Student toViewStudent(Student student)
    {
        com.hamidur.cunyfirst.viewTier.models.Student viewStudent = new com.hamidur.cunyfirst.viewTier.models.Student();

        viewStudent.setFirstName(student.getPerson().getFirstName());
        viewStudent.setLastName(student.getPerson().getLastName());
        viewStudent.setSsn(student.getPerson().getSsn());
        viewStudent.setDateOfBirth(student.getPerson().getDateOfBirth());
        viewStudent.setGender(toViewGender(student.getPerson().getGender()));

        viewStudent.setAddress(toViewAddress(student.getAddresses().iterator().next()));
        viewStudent.setHighSchoolInfo(toViewHighSchoolInfo(student.getHighSchoolInfo()));
        viewStudent.setContact(toViewContact(student.getContact()));

        return viewStudent;
    }

    public static com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo toViewHighSchoolInfo(HighSchoolInfo schoolInfo)
    {
        com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo view =
                new com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo();

        view.setHighSchoolName(schoolInfo.getHighSchoolName());
        view.setCity(schoolInfo.getCity());
        view.setCountry(schoolInfo.getCountry());
        view.setYear(schoolInfo.getYear());

        return view;
    }

    public static com.hamidur.cunyfirst.viewTier.models.Contact toViewContact(Contact contact)
    {
        return new com.hamidur.cunyfirst.viewTier.models.Contact(contact.getPhone().getPhone(), contact.getEmail(),
                contact.getCollegeEmail());
    }
}
