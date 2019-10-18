package com.hamidur.cunyfirst.daoTier.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Course")
@Table(name = "Courses")
public class Course implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseId", nullable = false, updatable = false)
    private Integer courseId;
    
    @Column(name = "courseTitle", nullable = false, length = 100)
    private String courseTitle;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "courseName", nullable = false, length = 3)
    private CourseName courseName;
    
    @Column(name = "courseLevel", nullable = false)
    private Integer courseLevel;
    
    @Column(name = "courseCredits", nullable = false)
    private Float courseCredits;
    
    @Column(name = "courseDescription", nullable = false, length = 100)
    private String description;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private Set<StudentCourse> studentCourseSet;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private Set<InstructorCourse> instructorCourses;
    
    public Course() {}
    
    public Course(String courseTitle, CourseName courseName, Integer courseLevel, Float courseCredits, String description)
    {
        this.courseTitle = courseTitle;
        this.courseName = courseName;
        this.courseLevel = courseLevel;
        this.courseCredits = courseCredits;
        this.description = description;
    }
    
    public Integer getCourseId() {
        return courseId;
    }
    
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    
    public String getCourseTitle() {
        return courseTitle;
    }
    
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    
    public CourseName getCourseName() {
        return courseName;
    }
    
    public void setCourseName(CourseName courseName) {
        this.courseName = courseName;
    }
    
    public Integer getCourseLevel() {
        return courseLevel;
    }
    
    public void setCourseLevel(Integer courseLevel) {
        this.courseLevel = courseLevel;
    }
    
    public Float getCredits() {
        return courseCredits;
    }
    
    public void setCredits(Float courseCredits) {
        this.courseCredits = courseCredits;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Float getCourseCredits()
    {
        return courseCredits;
    }
    
    public void setCourseCredits(Float courseCredits)
    {
        this.courseCredits = courseCredits;
    }
    
    public Set <StudentCourse> getStudentCourseSet()
    {
        return studentCourseSet;
    }
    
    public void setStudentCourseSet(Set <StudentCourse> studentCourseSet)
    {
        this.studentCourseSet = studentCourseSet;
    }
    
    public Set <InstructorCourse> getInstructorCourses()
    {
        return instructorCourses;
    }
    
    public void setInstructorCourses(Set <InstructorCourse> instructorCourses)
    {
        this.instructorCourses = instructorCourses;
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
                && Objects.equals(courseCredits, course.courseCredits)
                && Objects.equals(getDescription(), course.getDescription());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getCourseId(), getCourseTitle(), getCourseName(), getCourseLevel(), courseCredits, getDescription());
    }
    
    @Override
    public String toString()
    {
        return "Course{" + "courseId=" + courseId + ", courseTitle='" + courseTitle + '\'' + ", courseName=" + courseName + ", courseLevel=" + courseLevel + ", courseCredits=" + courseCredits + ", description='" + description + '\'' + '}';
    }
}

