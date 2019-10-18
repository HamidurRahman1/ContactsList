package com.hamidur.cunyfirst.daoTier.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity(name = "InstructorCourse")
@Table(name = "InstructorsCourses")
public class InstructorCourse implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructorCourseId")
    private Integer instructorCourseId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructorId")
    private Instructor instructor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    private Course course;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "termId")
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
    
    public Course getCourse()
    {
        return course;
    }
    
    public void setCourse(Course course)
    {
        this.course = course;
    }
    
    public Term getTerm()
    {
        return term;
    }
    
    public void setTerm(Term term)
    {
        this.term = term;
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
        return Objects.hash(getInstructorCourseId(), getInstructor().getInstructorId(), getCourse(), getTerm());
    }
    
    @Override
    public String toString()
    {
        return "InstructorCourse{" + "instructorCourseId=" + instructorCourseId + ", instructor=" +
                instructor.getInstructorId() + ", course=" + course.getCourseName() + " " + course.getCourseLevel()
                + ", term=" + term.getTermName() + " " + term.getTermYear() + '}';
    }
}
