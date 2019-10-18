package com.hamidur.cunyfirst.viewTier.models;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class TransferInfo implements Serializable
{
    private Integer transferId;
    @Size(min = 10, max = 50)
    private String transferSchoolName;
    private Term term;
    
    public TransferInfo() {}
    
    public TransferInfo(String transferSchoolName, Term term)
    {
        this.transferSchoolName = transferSchoolName;
        this.term = term;
    }
    
    public Integer getTransferId()
    {
        return transferId;
    }
    
    public void setTransferId(Integer transferId)
    {
        this.transferId = transferId;
    }
    
    public String getTransferSchoolName()
    {
        return transferSchoolName;
    }
    
    public void setTransferSchoolName(String transferSchoolName)
    {
        this.transferSchoolName = transferSchoolName;
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
        return "TransferInfo{" + "transferId=" + transferId + ", transferSchoolName='" +
                transferSchoolName + '\'' + ", term=" + term.getTermName() + " " + term.getTermYear() + '}';
    }
}
