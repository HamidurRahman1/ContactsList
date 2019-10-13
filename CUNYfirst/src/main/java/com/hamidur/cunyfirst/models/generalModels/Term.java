package com.hamidur.cunyfirst.models.generalModels;

import java.util.Objects;

public class Term
{
    private Integer termId;
    private String termName;
    
    public Term() {}

    public Term(String termName)
    {
        this.setTermName(termName);
    }

    public Term(Integer termId, String termName)
    {
        this.termId = termId;
        this.termName = termName;
    }
    
    public Integer getTermId()
    {
        return termId;
    }
    
    public void setTermId(Integer termId)
    {
        this.termId = termId;
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
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof Term)) return false;
        Term term = (Term) o;
        return getTermId().equals(term.getTermId()) && getTermName().equals(term.getTermName());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getTermId(), getTermName());
    }
    
    @Override
    public String toString()
    {
        return "Term{" + "termId=" + termId + ", termName='" + termName + '\'' + '}';
    }
}
