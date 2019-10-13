package com.hamidur.cunyfirst.models.generalModels;

import java.util.Objects;

public class SecurityQuestionAnswer
{
    private SecurityQuestion securityQuestion;
    private String answer;
    
    public SecurityQuestionAnswer() {}

    public SecurityQuestionAnswer(SecurityQuestion securityQuestion, String answer) {
        this.securityQuestion = securityQuestion;
        this.answer = answer;
    }

    public SecurityQuestion getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(SecurityQuestion securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SecurityQuestionAnswer)) return false;
        SecurityQuestionAnswer that = (SecurityQuestionAnswer) o;
        return Objects.equals(getSecurityQuestion(), that.getSecurityQuestion()) &&
                Objects.equals(getAnswer(), that.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSecurityQuestion(), getAnswer());
    }

    @Override
    public String toString() {
        return "SecurityQuestionAnswer{" +
                "securityQuestion=" + securityQuestion +
                ", answer='" + answer + '\'' +
                '}';
    }
}
