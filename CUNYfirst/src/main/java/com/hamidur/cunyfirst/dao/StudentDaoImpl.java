package com.hamidur.cunyfirst.dao;

import com.hamidur.cunyfirst.models.generalModels.Course;
import com.hamidur.cunyfirst.models.generalModels.Student;
import com.hamidur.cunyfirst.models.generalModels.Term;

import java.sql.Connection;
import java.util.List;

public class StudentDaoImpl implements StudentDAO
{
    private static Connection connection;

    @Override
    public Student getStudentById(Integer studentId)
    {
        return null;
    }

    @Override
    public Student getStudentBySSN(String ssn)
    {
        return null;
    }

    @Override
    public Student getStudentByLogin(String userName, String password)
    {
        return null;
    }

    @Override
    public void insertStudent(Student student)
    {

    }

    @Override
    public void updateStudent(Student student)
    {

    }

    @Override
    public boolean isExists(Integer studentId)
    {
        return false;
    }

    @Override
    public boolean isExists(String ssn)
    {
        return false;
    }

    @Override
    public boolean isLoginExists(String userName)
    {
        return false;
    }

    @Override
    public List<Student> getAllStudents()
    {
        return null;
    }

    @Override
    public List<Course> getAllCourses()
    {
        return null;
    }

    @Override
    public List<Course> getAllCoursesByTerm(Term term)
    {
        return null;
    }
}
