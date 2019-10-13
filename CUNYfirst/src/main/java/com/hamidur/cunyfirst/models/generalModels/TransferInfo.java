package com.hamidur.cunyfirst.models.generalModels;

public class TransferInfo
{
    private Integer transferInfoId;
    private String schoolName;
    private Term term;

    public TransferInfo() {}

    public TransferInfo(String schoolName, Term term) {
        this.schoolName = schoolName;
        this.term = term;
    }

    public TransferInfo(Integer transferInfoId, String schoolName, Term term) {
        this.transferInfoId = transferInfoId;
        this.schoolName = schoolName;
        this.term = term;
    }

    public Integer getTransferInfoId() {
        return transferInfoId;
    }

    public void setTransferInfoId(Integer transferInfoId) {
        this.transferInfoId = transferInfoId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "TransferInfo{" +
                "transferInfoId=" + transferInfoId +
                ", schoolName='" + schoolName + '\'' +
                ", term=" + term +
                '}';
    }
}
