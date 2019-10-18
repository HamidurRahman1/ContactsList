package com.hamidur.cunyfirst.daoTier.models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


@Entity(name = "Instructor")
@Table(name = "Instructors")
public class Instructor implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructorId", nullable = false, updatable = false)
    private Integer instructorId;
    
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "firstName", column = @Column(name = "firstName")),
            @AttributeOverride(name = "lastName", column = @Column(name = "lastName")),
            @AttributeOverride(name = "ssn", column = @Column(name = "ssn")),
            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "dob")),
            @AttributeOverride(name = "gender", column = @Column(name = "gender"))})
    private Person person;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor",
            cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
    private Set<InstructorCourse> instructorCourses = new LinkedHashSet <>();
    
    public Instructor()
    {
        this.person = new Person();
    }
    
    public Instructor(String firstName, String lastName, String ssn, LocalDate dob, Gender gender)
    {
        this.person = new Person(firstName, lastName, ssn, dob, gender);
    }
    
    public Integer getInstructorId()
    {
        return instructorId;
    }
    
    public void setInstructorId(Integer instructorId)
    {
        this.instructorId = instructorId;
    }
    
    public Person getPerson()
    {
        return person;
    }
    
    public void setPerson(Person person)
    {
        this.person = person;
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
        if(! (o instanceof Instructor)) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(getInstructorId(), that.getInstructorId())
                && Objects.equals(getPerson(), that.getPerson())
                && Objects.equals(getInstructorCourses(), that.getInstructorCourses());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getInstructorId(), getPerson(), getInstructorCourses());
    }
    
    @Override
    public String toString()
    {
        return "Instructor{" + "instructorId=" + instructorId + ", person=" + person + ", instructorCourses=" + instructorCourses + '}';
    }
}
