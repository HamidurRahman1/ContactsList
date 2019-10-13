package com.hamidur.cunyfirst.models.generalModels;

import java.util.Objects;

public class TransferInfo
{
    private String schoolName;
    private Term term;

    public TransferInfo() {}

    public TransferInfo(String schoolName, Term term) {
        this.schoolName = schoolName;
        this.term = term;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransferInfo)) return false;
        TransferInfo that = (TransferInfo) o;
        return Objects.equals(getSchoolName(), that.getSchoolName()) &&
                Objects.equals(getTerm(), that.getTerm());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchoolName(), getTerm());
    }

    @Override
    public String toString() {
        return "TransferInfo{" +
                "schoolName='" + schoolName + '\'' +
                ", term=" + term +
                '}';
    }
}
