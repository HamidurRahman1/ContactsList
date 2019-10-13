package com.hamidur.cunyfirst.models.generalModels;

import java.util.Objects;

public class Term
{
    private String termName;
    private Integer termYear;

    public Term() {}

    public Term(String termName)
    {
        this.setTermName(termName);
    }

    public Term(String termName, Integer termYear) {
        this.termName = termName;
        this.termYear = termYear;
    }

    public Integer getTermYear() {
        return termYear;
    }

    public void setTermYear(Integer termYear) {
        this.termYear = termYear;
    }
    
    public String getTermName()
    {
        return termName;
    }
    
    public void setTermName(String termName)
    {
        this.termName = termName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Term)) return false;
        Term term = (Term) o;
        return Objects.equals(getTermName(), term.getTermName()) &&
                Objects.equals(getTermYear(), term.getTermYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTermName(), getTermYear());
    }

    @Override
    public String toString() {
        return "Term{" +
                "termName='" + termName + '\'' +
                ", termYear=" + termYear +
                '}';
    }
}
