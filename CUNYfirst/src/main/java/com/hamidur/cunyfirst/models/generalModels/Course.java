package com.hamidur.cunyfirst.models.generalModels;

import java.util.Objects;

public class Course
{
    private String courseTitle;
    private CourseName courseName;
    private Integer courseLevel;
    private Float credits;
    private String description;

    public Course() {}

    public Course(String courseTitle, CourseName courseName, Integer courseLevel, Float credits, String description)
    {
        this.courseTitle = courseTitle;
        this.courseName = courseName;
        this.courseLevel = courseLevel;
        this.credits = credits;
        this.description = description;
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
        return Objects.equals(getCourseTitle(), course.getCourseTitle()) &&
                getCourseName() == course.getCourseName() &&
                Objects.equals(getCourseLevel(), course.getCourseLevel()) &&
                Objects.equals(getCredits(), course.getCredits()) &&
                Objects.equals(getDescription(), course.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseTitle(), getCourseName(), getCourseLevel(), getCredits(), getDescription());
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseTitle='" + courseTitle + '\'' +
                ", courseName=" + courseName +
                ", courseLevel=" + courseLevel +
                ", credits=" + credits +
                ", description='" + description + '\'' +
                '}';
    }
}
