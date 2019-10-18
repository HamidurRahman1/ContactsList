package com.hamidur.cunyfirst.viewTier.models;

import java.io.Serializable;
import java.util.Objects;

public class FAFSA implements Serializable
{
    private Integer fafsaId;
    private Term term;
    private Double amount;
    
    public FAFSA() {}
    
    public FAFSA(Term term, Double amount)
    {
        this.term = term;
        this.amount = amount;
    }
    
    public Integer getFafsaId()
    {
        return fafsaId;
    }
    
    public void setFafsaId(Integer fafsaId)
    {
        this.fafsaId = fafsaId;
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
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof FAFSA)) return false;
        FAFSA fafsa = (FAFSA) o;
        return Objects.equals(getFafsaId(), fafsa.getFafsaId())
                && Objects.equals(getTerm(), fafsa.getTerm())
                && Objects.equals(getAmount(), fafsa.getAmount());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getFafsaId(), getTerm(), getAmount());
    }
    
    @Override
    public String toString()
    {
        return "FAFSA{" + "fafsaId=" + fafsaId + ", term=" + term + ", amount=" + amount + '}';
    }
}
