package com.hamidur.cunyfirst.models.generalModels;

import java.util.Objects;

public class FAFSA
{
    private Integer year;
    private Double amount;
    private Term term;
    
    public FAFSA() {}

    public FAFSA(Integer year, Double amount, Term term) {
        this.year = year;
        this.amount = amount;
        this.term = term;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FAFSA)) return false;
        FAFSA fafsa = (FAFSA) o;
        return Objects.equals(getYear(), fafsa.getYear()) &&
                Objects.equals(getAmount(), fafsa.getAmount()) &&
                Objects.equals(getTerm(), fafsa.getTerm());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getAmount(), getTerm());
    }

    @Override
    public String toString() {
        return "FAFSA{" +
                "year=" + year +
                ", amount=" + amount +
                ", term=" + term +
                '}';
    }
}
