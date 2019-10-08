package com.hamidur.cunyfirst.models;

import com.hamidur.cunyfirst.models.modelProps.CourseLevel;
import com.hamidur.cunyfirst.models.modelProps.CourseName;

import java.util.Objects;

public class Course
{
    private Integer courseId;
    private String courseTitle;
    private CourseName courseName;
    private CourseLevel courseLevel;
    private Float credits;
    private String description;

    public Course() {}

    public Course(Integer courseId, String courseTitle, CourseName courseName, CourseLevel courseLevel, Float credits, String description) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseName = courseName;
        this.courseLevel = courseLevel;
        this.credits = credits;
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

    public CourseLevel getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(CourseLevel courseLevel) {
        this.courseLevel = courseLevel;
    }

    public Float getCredits() {
        return credits;
    }

    public void setCredits(Float credits) {
        this.credits = credits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getCourseName() == course.getCourseName() &&
                getCourseLevel() == course.getCourseLevel();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseName(), getCourseLevel());
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseName=" + courseName +
                ", courseLevel=" + courseLevel +
                ", credits=" + credits +
                ", description='" + description + '\'' +
                '}';
    }
}
