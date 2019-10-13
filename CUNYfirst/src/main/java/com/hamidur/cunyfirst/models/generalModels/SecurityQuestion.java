package com.hamidur.cunyfirst.models.generalModels;

import java.util.Objects;

public class SecurityQuestion
{
    private Integer questionId;
    private String question;
    
    public SecurityQuestion() {}
    
    public SecurityQuestion(String question)
    {
        this.setQuestion(question);
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
        return getQuestionId().equals(that.getQuestionId()) && getQuestion().equals(that.getQuestion());
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
