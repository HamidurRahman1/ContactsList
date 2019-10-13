package com.hamidur.cunyfirst.models.dbModels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

@Entity(name = "StudentCourse")
@Table(name = "StudentsCourses")
public class StudentCourse implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer studentCourseId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    private Course course;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "courseStatus")
    private CourseStatus courseStatus;
    
    @Column(name = "grade")
    private String grade;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "termId")
    private Term term;
    
    public StudentCourse() {}
    
    public StudentCourse(Student student, Course course, CourseStatus courseStatus, Term term)
    {
        this.student = student;
        this.course = course;
        this.courseStatus = courseStatus;
        this.term = term;
    }
    
    public StudentCourse(Student student, Course course, CourseStatus courseStatus, String grade, Term term)
    {
        this.student = student;
        this.course = course;
        this.courseStatus = courseStatus;
        this.grade = grade;
        this.term = term;
    }
    
    public Integer getStudentCourseId()
    {
        return studentCourseId;
    }
    
    public void setStudentCourseId(Integer studentCourseId)
    {
        this.studentCourseId = studentCourseId;
    }
    
    public Term getTerm()
    {
        return term;
    }
    
    public void setTerm(Term term)
    {
        this.term = term;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public CourseStatus getCourseStatus() {
        return courseStatus;
    }
    
    public void setCourseStatus(CourseStatus courseStatus) {
        this.courseStatus = courseStatus;
    }
    
    public String getGrade() {
        return grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof StudentCourse)) return false;
        StudentCourse that = (StudentCourse) o;
        return Objects.equals(getStudentCourseId(), that.getStudentCourseId()) && Objects.equals(getStudent(),
                that.getStudent()) && Objects.equals(getCourse(), that.getCourse())
                && getCourseStatus() == that.getCourseStatus() && Objects.equals(getGrade(),
                that.getGrade()) && Objects.equals(getTerm(), that.getTerm());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getStudentCourseId(), getStudent(), getCourse(), getCourseStatus(), getGrade(), getTerm());
    }
    
    @Override
    public String toString()
    {
        return "StudentCourse{" + "studentCourseId=" + studentCourseId + ", student=" + student.getStudentId()
                + ", course=" + course.getCourseName() + " " + course.getCourseLevel()
                + ", courseStatus=" + courseStatus + ", grade='" + grade
                + ", term=" + term.getTermName() + " " + term.getTermYear() + '}';
    }
}
