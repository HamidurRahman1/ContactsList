package com.hamidur.cunyfirst.models.dbModels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity(name = "SecurityQuestion")
@Table(name = "SecurityQuestions")
public class SecurityQuestion implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionId")
    private Integer questionId;
    
    @Column(name = "question")
    private String question;
    
    public SecurityQuestion() {}
    
    public SecurityQuestion(String question)
    {
        this.question = question;
    }
    
    public Integer getQuestionId()
    {
        return questionId;
    }
    
    public void setQuestionId(Integer questionId)
    {
        this.questionId = questionId;
    }
    
    public String getQuestion()
    {
        return question;
    }
    
    public void setQuestion(String question)
    {
        this.question = question;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof SecurityQuestion)) return false;
        SecurityQuestion that = (SecurityQuestion) o;
        return Objects.equals(getQuestionId(), that.getQuestionId()) && Objects.equals(getQuestion(), that.getQuestion());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getQuestionId(), getQuestion());
    }
    
    @Override
    public String toString()
    {
        return "SecurityQuestion{" + "questionId=" + questionId + ", question='" + question + '\'' + '}';
    }
}
