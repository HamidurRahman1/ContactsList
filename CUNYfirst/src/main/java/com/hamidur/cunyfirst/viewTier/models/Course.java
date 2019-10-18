package com.hamidur.cunyfirst.viewTier.models;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class Course implements Serializable
{
    private Integer courseId;
    
    @Size(min = 10, max = 100)
    private String courseTitle;
    
    @Size(max = 3)
    private CourseName courseName;
    
    @Size(max = 3)
    private CourseLevel courseLevel;
    private Float courseCredits;
    
    @Size(min = 10, max = 100)
    private String description;
    
    public Course() {}
    
    public Course(String courseTitle, CourseName courseName, CourseLevel courseLevel, Float courseCredits, String description)
    {
        this.courseTitle = courseTitle;
        this.courseName = courseName;
        this.courseLevel = courseLevel;
        this.courseCredits = courseCredits;
        this.description = description;
    }
    
    public Integer getCourseId()
    {
        return courseId;
    }
    
    public void setCourseId(Integer courseId)
    {
        this.courseId = courseId;
    }
    
    public String getCourseTitle()
    {
        return courseTitle;
    }
    
    public void setCourseTitle(String courseTitle)
    {
        this.courseTitle = courseTitle;
    }
    
    public CourseName getCourseName()
    {
        return courseName;
    }
    
    public void setCourseName(CourseName courseName)
    {
        this.courseName = courseName;
    }
    
    public CourseLevel getCourseLevel()
    {
        return courseLevel;
    }
    
    public void setCourseLevel(CourseLevel courseLevel)
    {
        this.courseLevel = courseLevel;
    }
    
    public Float getCourseCredits()
    {
        return courseCredits;
    }
    
    public void setCourseCredits(Float courseCredits)
    {
        this.courseCredits = courseCredits;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(getCourseId(), course.getCourseId())
                && Objects.equals(getCourseTitle(), course.getCourseTitle())
                && getCourseName() == course.getCourseName()
                && Objects.equals(getCourseLevel(), course.getCourseLevel())
                && Objects.equals(getCourseCredits(), course.getCourseCredits())
                && Objects.equals(getDescription(), course.getDescription());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getCourseId(), getCourseTitle(), getCourseName(), getCourseLevel(), getCourseCredits(), getDescription());
    }
    
    @Override
    public String toString()
    {
        return "Course{" + "courseId=" + courseId + ", courseTitle='" + courseTitle + '\'' + ", courseName="
                + courseName + ", courseLevel=" + courseLevel.getValue() + ", courseCredits="
                + courseCredits + ", description='" + description + '\'' + '}';
    }
}
