package com.hamidur.cunyfirst.viewTier.models;

public enum CourseStatus
{
    IN_PROGRESS("INP"), TAKEN("TKN"), TRANSFER("TRN");
    
    private final String status;
    
    CourseStatus(final String status)
    {
        this.status = status;
    }
    
    public String getValue()
    {
        return status;
    }
}