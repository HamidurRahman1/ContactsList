package com.hamidur.cunyfirst.viewTier.models;

public enum Grade
{
    A_PLUS("A+"), A("A"), A_MINUS("A-"),
    B_PLUS("B+"), B("B"), B_MINUS("B-"),
    C_PLUS("C+"), C("C"), C_MINUS("C-"),
    D_PLUS("D+"), D("D"), D_MINUS("D-"),
    
    PASS("P"), SATISFACTORY("S"), UNSATISFACTORY("U"), REPEAT("R"),
    
    UNOFFICIAL_W("WU"), WITHDRAWAL("W"), WN("WN"), INCOMPLETE("INC"), WAVED("@");
    
    private final String grade;
    
    Grade(final String grade)
    {
        this.grade = grade;
    }
    
    public String getValue()
    {
        return grade;
    }
}
