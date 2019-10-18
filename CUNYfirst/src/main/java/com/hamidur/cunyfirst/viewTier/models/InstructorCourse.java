package com.hamidur.cunyfirst.viewTier.models;

import java.io.Serializable;
import java.util.Objects;

public class InstructorCourse implements Serializable
{
    private Integer instructorCourseId;
    private Instructor instructor;
    private Course course;
    private Term term;
    
    public InstructorCourse() {}
    
    public InstructorCourse(Instructor instructor, Course course, Term term)
    {
        this.instructor = instructor;
        this.course = course;
        this.term = term;
    }
    
    public Integer getInstructorCourseId()
    {
        return instructorCourseId;
    }
    
    public void setInstructorCourseId(Integer instructorCourseId)
    {
        this.instructorCourseId = instructorCourseId;
    }
    
    public Instructor getInstructor()
    {
        return instructor;
    }
    
    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }
    
    public Term getTerm()
    {
        return term;
    }
    
    public void setTerm(Term term)
    {
        this.term = term;
    }
    
    public Course getCourse()
    {
        return course;
    }
    
    public void setCourse(Course course)
    {
        this.course = course;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof InstructorCourse)) return false;
        InstructorCourse that = (InstructorCourse) o;
        return Objects.equals(getInstructorCourseId(), that.getInstructorCourseId())
                && Objects.equals(getInstructor(), that.getInstructor())
                && Objects.equals(getCourse(), that.getCourse())
                && Objects.equals(getTerm(), that.getTerm());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getInstructorCourseId(), getInstructor(), getCourse(), getTerm());
    }
    
    @Override
    public String toString()
    {
        return "InstructorCourse{" + "instructorCourseId=" + instructorCourseId + ", instructor="
                + instructor.getInstructorId() + ", course=" + course + ", term=" + term + '}';
    }
}
