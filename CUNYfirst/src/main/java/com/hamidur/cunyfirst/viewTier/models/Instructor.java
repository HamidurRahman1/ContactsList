package com.hamidur.cunyfirst.viewTier.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Instructor extends Person implements Serializable
{
    private Integer instructorId;
    private Set<InstructorCourse> instructorCourses = new LinkedHashSet <>();
    
    public Instructor()
    {
        super();
    }
    
    public Instructor(String firstName, String lastName, String ssn, LocalDate dateOfBirth, Gender gender)
    {
        super(firstName, lastName, ssn, dateOfBirth, gender);
    }
    
    public Integer getInstructorId()
    {
        return instructorId;
    }
    
    public void setInstructorId(Integer instructorId)
    {
        this.instructorId = instructorId;
    }
    
    public Set <InstructorCourse> getInstructorCourses()
    {
        return instructorCourses;
    }
    
    public void setInstructorCourses(Set <InstructorCourse> instructorCourses)
    {
        this.instructorCourses = instructorCourses;
    }
    
    public void addInstructorCourse(InstructorCourse instructorCourse)
    {
        instructorCourses.add(instructorCourse);
    }
    
    public void removeInstructorCourse(InstructorCourse instructorCourse)
    {
        instructorCourses.remove(instructorCourse);
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof Instructor)) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(getInstructorId(), that.getInstructorId())
                && Objects.equals(getInstructorCourses(), that.getInstructorCourses());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getInstructorId(), getInstructorCourses());
    }
    
    @Override
    public String toString()
    {
        return "Instructor{" + "instructorId=" + instructorId + ", instructorCourses=" + instructorCourses + '}';
    }
}
