package com.hamidur.cunyfirst.models.dbModels;

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

@Entity(name = "StudentSecurityQuestion")
@Table(name = "Students_SecurityQuestions")
public class StudentSecurityQuestion implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionAnswerId")
    private Integer questionAnswerId;
    
    @Column(name = "answer")
    private String answer;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    private SecurityQuestion securityQuestion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;
    
    public StudentSecurityQuestion() {}
    
    public StudentSecurityQuestion(SecurityQuestion securityQuestion, String answer, Student student)
    {
        this.securityQuestion = securityQuestion;
        this.answer = answer;
        this.student = student;
    }
    
    public Integer getQuestionAnswerId()
    {
        return questionAnswerId;
    }
    
    public void setQuestionAnswerId(Integer questionAnswerId)
    {
        this.questionAnswerId = questionAnswerId;
    }
    
    public SecurityQuestion getSecurityQuestion()
    {
        return securityQuestion;
    }
    
    public void setSecurityQuestion(SecurityQuestion securityQuestion)
    {
        this.securityQuestion = securityQuestion;
    }
    
    public String getAnswer()
    {
        return answer;
    }
    
    public void setAnswer(String answer)
    {
        this.answer = answer;
    }
    
    public Student getStudent()
    {
        return student;
    }
    
    public void setStudent(Student student)
    {
        this.student = student;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof StudentSecurityQuestion)) return false;
        StudentSecurityQuestion that = (StudentSecurityQuestion) o;
        return Objects.equals(getQuestionAnswerId(), that.getQuestionAnswerId()) && Objects.equals(getSecurityQuestion(),
                that.getSecurityQuestion()) && Objects.equals(getAnswer(),
                that.getAnswer()) && Objects.equals(getStudent(), that.getStudent());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getQuestionAnswerId(), getSecurityQuestion(), getAnswer(), getStudent());
    }
    
    @Override
    public String toString()
    {
        return "StudentSecurityQuestion{" + "questionAnswerId=" + questionAnswerId + ", securityQuestion=" + securityQuestion.getQuestion() + ", answer='" + answer + '\'' + ", student=" + student.getStudentId() + '}';
    }
}
