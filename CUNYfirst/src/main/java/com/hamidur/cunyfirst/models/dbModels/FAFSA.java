package com.hamidur.cunyfirst.models.dbModels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity(name = "FAFSA")
@Table(name = "FAFSAs")
public class FAFSA implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fafsaId")
    private Integer fafsaId;
    
    @Column(name = "amount")
    private Double amount;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "termId")
    private Term term;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;
    
    public FAFSA() {}
    
    public Integer getFafsaId()
    {
        return fafsaId;
    }
    
    public void setFafsaId(Integer fafsaId)
    {
        this.fafsaId = fafsaId;
    }
    
    public Double getAmount()
    {
        return amount;
    }
    
    public void setAmount(Double amount)
    {
        this.amount = amount;
    }
    
    public Term getTerm()
    {
        return term;
    }
    
    public void setTerm(Term term)
    {
        this.term = term;
    }
    
    public Student getStudent()
    {
        return student;
    }
    
    public void setStudent(Student student)
    {
        this.student = student;
    }
    
    @Override
    public String toString()
    {
        return "FAFSA{" + "fafsaId=" + fafsaId + ", amount=" + amount + ", term=" + term + ", studentId=" +
                student.getStudentId() + '}';
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof FAFSA)) return false;
        FAFSA fafsa = (FAFSA) o;
        return Objects.equals(getFafsaId(), fafsa.getFafsaId()) && Objects.equals(getAmount(),
                fafsa.getAmount()) && Objects.equals(getTerm(), fafsa.getTerm())
                && Objects.equals(getStudent(), fafsa.getStudent());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getFafsaId(), getAmount(), getTerm(), getStudent());
    }
}
