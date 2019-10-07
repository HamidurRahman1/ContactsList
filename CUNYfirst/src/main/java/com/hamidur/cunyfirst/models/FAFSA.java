package com.hamidur.cunyfirst.models;

public class FAFSA
{
    private Integer fafsaId;
    private Integer year;
    private Double amount;
    private Term term;
    
    public FAFSA() {}

    public FAFSA(Integer year, Double amount, Term term) {
        this.year = year;
        this.amount = amount;
        this.term = term;
    }

    public Integer getFafsaId()
    {
        return fafsaId;
    }
    
    public void setFafsaId(Integer fafsaId)
    {
        this.fafsaId = fafsaId;
    }
    
    public Integer getYear()
    {
        return year;
    }
    
    public void setYear(Integer year)
    {
        this.year = year;
    }
    
    public Term getTerm()
    {
        return term;
    }
    
    public void setTerm(Term term)
    {
        this.term = term;
    }
    
    public Double getAmount()
    {
        return amount;
    }
    
    public void setAmount(Double amount)
    {
        this.amount = amount;
    }
    
    @Override
    public String toString()
    {
        return "FAFSA{" + "fafsaId=" + fafsaId + ", year=" + year + ", term=" + term.getTermName() + ", amount=" + amount + '}';
    }
}
