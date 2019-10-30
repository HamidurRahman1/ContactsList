package com.hamidur.cunyfirst.daoTier.util;

import com.hamidur.cunyfirst.daoTier.models.Address;
import com.hamidur.cunyfirst.daoTier.models.Contact;
import com.hamidur.cunyfirst.daoTier.models.Course;
import com.hamidur.cunyfirst.daoTier.models.CourseName;
import com.hamidur.cunyfirst.daoTier.models.Gender;
import com.hamidur.cunyfirst.daoTier.models.HighSchoolInfo;
import com.hamidur.cunyfirst.daoTier.models.Instructor;
import com.hamidur.cunyfirst.daoTier.models.Person;
import com.hamidur.cunyfirst.daoTier.models.Student;
import com.hamidur.cunyfirst.daoTier.models.Term;
import com.hamidur.cunyfirst.daoTier.models.TransferInfo;

import java.sql.Date;
import java.time.LocalDate;

public class Utility
{
//    private ApplicationContext applicationContext;

    public static com.hamidur.cunyfirst.viewTier.models.Course toViewCourse(Course course)
    {
        return new com.hamidur.cunyfirst.viewTier.models.Course(course.getCourseTitle(),
                com.hamidur.cunyfirst.viewTier.models.CourseName.valueOf(course.getCourseName().getValue()),
                toViewCourseLevel(course.getCourseLevel()), course.getCourseCredits(), course.getDescription());
    }

    public static Course toDaoCourse(com.hamidur.cunyfirst.viewTier.models.Course course)
    {
        return new Course(course.getCourseTitle(), CourseName.valueOf(course.getCourseName().getValue()),
                course.getCourseLevel().getValue(), course.getCourseCredits(), course.getDescription());
    }

    public static Integer toDaoCourseLevel(com.hamidur.cunyfirst.viewTier.models.CourseLevel courseLevel)
    {
        return courseLevel.getValue();
    }

    public static com.hamidur.cunyfirst.viewTier.models.CourseLevel toViewCourseLevel(Integer courseLevel)
    {
        return com.hamidur.cunyfirst.viewTier.models.CourseLevel.valueOf(String.valueOf(courseLevel));
    }

    public static Instructor toDaoInstructor(com.hamidur.cunyfirst.viewTier.models.Instructor instructor)
    {
        return new Instructor(instructor.getFirstName(), instructor.getLastName(), instructor.getSsn(),
                instructor.getDateOfBirth(), Utility.toDaoGender(instructor.getGender()));
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
        viewStudent.setTransferInfo(toViewTransferInfo(student.getTransferInfo()));

        return viewStudent;
    }

    public static Student toDaoStudent(com.hamidur.cunyfirst.viewTier.models.Student student)
    {
        Student daoStudent = new Student();
        Person person = new Person();

        person.setFirstName(student.getFirstName());
        person.setLastName(student.getLastName());
        person.setSsn(student.getSsn());
        person.setDateOfBirth(student.getDateOfBirth());
        person.setGender(Utility.toDaoGender(student.getGender()));

        daoStudent.setPerson(person);
        daoStudent.addAddress(Utility.toDaoAddress(student.getAddress()));
        daoStudent.setContact(Utility.toDaoContact(student.getContact()));
        daoStudent.setHighSchoolInfo(Utility.toDaoHighSchoolInfo(student.getHighSchoolInfo()));
        daoStudent.setTransferInfo(Utility.toDaoTransferInfo(student.getTransferInfo()));

        return daoStudent;
    }

    public static com.hamidur.cunyfirst.viewTier.models.TransferInfo toViewTransferInfo(TransferInfo transferInfo)
    {
        return new com.hamidur.cunyfirst.viewTier.models.TransferInfo
                (transferInfo.getTransferSchoolName(), toViewTerm(transferInfo.getTerm()));
    }

    public static TransferInfo toDaoTransferInfo(com.hamidur.cunyfirst.viewTier.models.TransferInfo transferInfo)
    {
        return new TransferInfo(transferInfo.getTransferSchoolName(), toDaoTerm(transferInfo.getTerm()));
    }

    public static com.hamidur.cunyfirst.viewTier.models.Term toViewTerm(Term term)
    {
        return new com.hamidur.cunyfirst.viewTier.models.Term(term.getTermName(), term.getTermYear());
    }

    public static Term toDaoTerm(com.hamidur.cunyfirst.viewTier.models.Term term)
    {
        return new Term(term.getTermName(), term.getTermYear());
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

    public static HighSchoolInfo toDaoHighSchoolInfo(com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo schoolInfo)
    {
        return new HighSchoolInfo(schoolInfo.getHighSchoolName(), schoolInfo.getYear(), schoolInfo.getCity(),
                schoolInfo.getCountry());
    }

    public static com.hamidur.cunyfirst.viewTier.models.Contact toViewContact(Contact contact)
    {
        return new com.hamidur.cunyfirst.viewTier.models.Contact(contact.getPhone().getPhone(), contact.getEmail(),
                contact.getCollegeEmail());
    }

    public static Contact toDaoContact(com.hamidur.cunyfirst.viewTier.models.Contact contact)
    {
        return new Contact(contact.getCollegeEmail(), contact.getEmail(), contact.getPhone());
    }
}
