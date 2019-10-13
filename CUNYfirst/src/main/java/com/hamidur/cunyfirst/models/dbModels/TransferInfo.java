package com.hamidur.cunyfirst.models.dbModels;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "TransferInfo")
@Table(name = "TransferInfos")
public class TransferInfo implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transferInfoId")
    private Integer transferInfoId;
    
    @Column(name = "transferSchoolName")
    private String transferSchoolName;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "termId", foreignKey = @ForeignKey(name = "termId"))
    private Term term;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;
    
    public TransferInfo() {}
    
    public TransferInfo(String transferSchoolName, Term term)
    {
        this.transferSchoolName = transferSchoolName;
        this.term = term;
    }
    
    public TransferInfo(String transferSchoolName, Term term, Student student)
    {
        this.transferSchoolName = transferSchoolName;
        this.term = term;
        this.student = student;
    }
    
    public Integer getTransferInfoId()
    {
        return transferInfoId;
    }
    
    public void setTransferInfoId(Integer transferInfoId)
    {
        this.transferInfoId = transferInfoId;
    }
    
    public String getTransferSchoolName()
    {
        return transferSchoolName;
    }
    
    public void setTransferSchoolName(String transferSchoolName)
    {
        this.transferSchoolName = transferSchoolName;
    }
    
    public Student getStudent()
    {
        return student;
    }
    
    public void setStudent(Student student)
    {
        this.student = student;
    }
    
    public Term getTerm()
    {
        return term;
    }
    
    public void setTerm(Term term)
    {
        this.term = term;
    }
    
    @Override
    public String toString()
    {
        return "TransferInfo{" + "transferInfoId=" + transferInfoId + ", transferSchoolName='" + transferSchoolName + '\'' + ", term=" + term + ", student=" + student.getStudentId() + '}';
    }
}

