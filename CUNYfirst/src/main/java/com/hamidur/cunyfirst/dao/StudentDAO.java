package com.hamidur.cunyfirst.dao;

import com.hamidur.cunyfirst.models.Course;
import com.hamidur.cunyfirst.models.Student;
import com.hamidur.cunyfirst.models.Term;

import java.util.List;

public interface StudentDAO
{
    Student getStudentById(Integer studentId);
    Student getStudentBySSN(String ssn);
    Student getStudentByLogin(String userName, String password);

    void insertStudent(Student student);
    void updateStudent(Student student);

    boolean isExists(Integer studentId);
    boolean isExists(String ssn);
    boolean isLoginExists(String userName);

    List<Student> getAllStudents();
    List<Course> getAllCourses();
    List<Course> getAllCoursesByTerm(Term term);
}
