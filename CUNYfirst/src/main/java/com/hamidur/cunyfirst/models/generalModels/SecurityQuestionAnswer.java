package com.hamidur.cunyfirst.models.generalModels;

import java.util.Objects;

public class SecurityQuestionAnswer
{
    private Integer studentId;
    private SecurityQuestion securityQuestion;
    private String answer;
    
    public SecurityQuestionAnswer() {}

    public SecurityQuestionAnswer(Integer studentId, SecurityQuestion securityQuestion, String answer) {
        this.studentId = studentId;
        this.securityQuestion = securityQuestion;
        this.answer = answer;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof SecurityQuestionAnswer)) return false;
        SecurityQuestionAnswer that = (SecurityQuestionAnswer) o;
        return Objects.equals(getStudentId(), that.getStudentId()) &&
                Objects.equals(getSecurityQuestion(), that.getSecurityQuestion());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getStudentId(), getSecurityQuestion());
    }

    @Override
    public String toString() {
        return "SecurityQuestionAnswer{" +
                "studentId=" + studentId +
                ", securityQuestion=" + securityQuestion +
                ", answer='" + answer + '\'' +
                '}';
    }
}
