package com.hamidur.cunyfirst.models.generalModels;

import java.util.Objects;

public class SecurityQuestion
{
    private String question;
    
    public SecurityQuestion() {}
    
    public SecurityQuestion(String question)
    {
        this.setQuestion(question);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SecurityQuestion)) return false;
        SecurityQuestion that = (SecurityQuestion) o;
        return Objects.equals(getQuestion(), that.getQuestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestion());
    }

    @Override
    public String toString() {
        return "SecurityQuestion{" +
                "question='" + question + '\'' +
                '}';
    }
}
