package com.hamidur.cunyfirst.viewTier.models;

public enum Gender
{
    MALE("M"), FEMALE("F"), OTHER("O");
    
    private final String gender;
    
    Gender(final String gender)
    {
        this.gender = gender;
    }
    
    public String getValue()
    {
        return gender;
    }
}
